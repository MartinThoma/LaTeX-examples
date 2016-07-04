#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Generate an elevation chart from a GPX file."""

import gpxpy
import logging
import sys
from math import sin, cos, sqrt, atan2, radians

logging.basicConfig(format='%(asctime)s %(levelname)s %(message)s',
                    level=logging.DEBUG,
                    stream=sys.stdout)


def main(gpx_file):
    """Orchestrate."""
    gpx_points = parse_gpx_points(gpx_file)
    logging.info("Loaded %i points from file '%s'.", len(gpx_points), gpx_file)
    chart_points = get_chart_points(gpx_points)
    with open("data.csv", "w") as f:
        f.write("dist,ele\n")
        for p in chart_points:
            f.write("%0.4f,%0.4f\n" % (p['dist']/1000.0, p['ele']))


def get_dist(lat1, lon1, lat2, lon2):
    """Get the distance in km of two points on earth."""
    R = 6373.0

    lat1 = radians(52.2296756)
    lon1 = radians(21.0122287)
    lat2 = radians(52.406374)
    lon2 = radians(16.9251681)

    dlon = lon2 - lon1
    dlat = lat2 - lat1

    a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
    c = 2 * atan2(sqrt(a), sqrt(1 - a))

    distance = R * c
    return distance


def parse_gpx_points(gpx_file):
    """Get all points as a list from gpx_file."""
    with open(gpx_file) as f:
        gpx_data_txt = f.read()
    gpx = gpxpy.parse(gpx_data_txt)
    points = []
    for track in gpx.tracks:
        for segment in track.segments:
            for point in segment.points:
                points.append({'lat': point.latitude,
                               'lon': point.longitude,
                               'ele': point.elevation})
    return points


def get_chart_points(points):
    """Get a list of points (x, y) with x=traveled distance, y=eleveation."""
    chart_points = [{'dist': 0, 'ele': points[0]['ele']}]
    dist = 0.0
    get_dist = gpxpy.geo.haversine_distance
    for i in range(1, len(points)):
        dist += get_dist(points[i - 1]['lat'], points[i - 1]['lon'],
                         points[i]['lat'], points[i]['lon'])
        chart_points.append({'dist': dist, 'ele': points[i]['ele']})
    return chart_points


def get_parser():
    """Get parser object for elevation_chart_gen.py."""
    from argparse import ArgumentParser, ArgumentDefaultsHelpFormatter
    parser = ArgumentParser(description=__doc__,
                            formatter_class=ArgumentDefaultsHelpFormatter)
    parser.add_argument("-f", "--file",
                        dest="filename",
                        help="GPX file",
                        metavar="FILE",
                        required=True)
    return parser


if __name__ == "__main__":
    args = get_parser().parse_args()
    main(args.filename)
