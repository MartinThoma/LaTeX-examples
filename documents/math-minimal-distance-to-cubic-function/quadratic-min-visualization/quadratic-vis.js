'use strict';

/* global variables */
var STRETCH_X = 3;
var STRETCH_Y = 0.5;
var X_MIN = -10;
var X_MAX = +10;
var Y_MIN = -10;
var Y_MAX = +10;
var X_OFFSET = -128;
var Y_OFFSET = 256;
var INITIAL_RADIUS = 20;
var POINT_RADIUS = 5;

/*******************************************************************/
/* Graphics                                                        */
/*******************************************************************/
/** 
 * Calculates coordinates from worldspace to screenspace
 * @param {Number} x the coordinate you want to transform
 * @param {bool} isX true iff x is a x-coordinate, otherwise false
 * @return {Number} transformed coordinate
 */
function c(x, isX) {
    if (isX) {
        return STRETCH_X * (x - X_OFFSET);
    }

    return STRETCH_Y * (-x + Y_OFFSET);
}

/** 
 * Calculates coordinates from screenspace to worldspace
 * @param {Number} x the coordinate you want to transform
 * @param {bool} isX true iff x is a x-coordinate, otherwise false
 * @return {Number} transformed coordinate
 */
function r(x, isX) {
    if (isX) {
        return (x / STRETCH_X) + X_OFFSET;
    }

    return (-x / STRETCH_Y) + Y_OFFSET;
}

function setCursorByID(id,cursorStyle) {
    var elem;
    if (document.getElementById &&
    (elem=document.getElementById(id)) ) {
        if (elem.style) elem.style.cursor=cursorStyle;
    }
}

function drawEllipse(centerX, centerY, width, height) {
    context.beginPath() ;

    var x             = centerX;
    var y             = centerY;
    var rx            = width;
    var ry            = height;
    var rotation      = 0; // The rotation of the ellipse (in radians)
    var start         = 0; // The start angle (in radians)
    var end           = 2 * Math.PI; // The end angle (in radians)
    var anticlockwise = false;

    context.ellipse(x, y, rx, ry, rotation, start, end, anticlockwise);
    context.fillStyle = "rgba(255, 0, 0, 0.5)";
    context.fill();
}

function getColor(i, transparency) {
    //var t = (i+1)*(360/k);
    //var color = 'hsla('+t+', 100%, 50%, '+transparency+')';
    var x = i / 256;
    if (x > 1) {x = 1.0;}
    x = parseInt(x*255);
    var color = 'rgba('+x+','+x+','+x+','+transparency+')';
    return color;
}

function drawQuadraticFunction(canvas) {
    var add = parseInt(document.getElementById("density").value);

    context.beginPath();
    context.fillStyle = 'red';

    context.moveTo(0, c(getValue(r(0))), false);
    for (var xS=0; xS < canvas.width; xS+=add) {
        var x = r(xS);
        var y = getValue(x);
        //context.fillRect(c(x), c(y, false), add/2, add/2);
        context.lineTo(c(x, true), c(y, false));
    }

    context.closePath();
    context.stroke();
}

/*******************************************************************/
/* Math                                                            */
/*******************************************************************/
function euklideanDist(p1, p2) {
    return Math.sqrt(
                  Math.pow(p1["x"]-p2["x"], 2) 
                + Math.pow(p1["y"]-p2["y"], 2));
}

/** 
 * Calculates the value of a cubic function at x
 * @param {Number} x
 * @return {Number} f(x)
 */
function getValue(x) {
    var a = parseFloat(document.getElementById("a").value);
    var b = parseFloat(document.getElementById("b").value);
    var c1 = parseFloat(document.getElementById("c").value);
    return a*x*x+b*x+c1;
}

/** 
 * Calculates the drivate f'(x)
 * @param {Number} x
 * @return {Number} f'(x)
 */
function getDValue(x) {
    var a = parseFloat(document.getElementById("a").value);
    var b = parseFloat(document.getElementById("b").value);
    return 2*a*x+b;
}

/** 
 * Calculates the drivate f''(x)
 * @param {Number} x
 * @return {Number} f''(x)
 */
function getDDValue(x) {
    var a = parseFloat(document.getElementById("a").value);
    return 2*a;
}

/** 
 * Calculates (f(x)^2)' = ((a*x*x+b*x+c)^2)' = 2 (b + 2 a x) (c + x (b + a x))
 * @param {Number} x
 * @return {Number} (f(x)^2)'
 */
function gedSquaredValueD(x) {
    var a = parseFloat(document.getElementById("a").value);
    var b = parseFloat(document.getElementById("b").value);
    var c1 = parseFloat(document.getElementById("c").value);
    return 2*(2*a*x+b)*(x*(a*x+b)+c1);
}

/** 
 * Calculates (f(x)^2)'' = ((a*x*x+b*x+c)^2)'' = 2 (b^2 + 6 a b x + 2 a (c + 3 a x^2))
 * @param {Number} x
 * @return {Number} (f(x)^2)''
 */
function gedSquaredValueDD(x) {
    var a = parseFloat(document.getElementById("a").value);
    var b = parseFloat(document.getElementById("b").value);
    var c1 = parseFloat(document.getElementById("c").value);

    return 2*(b*b+6*a*b*x+2*a*(c1+3*a*x*x));
}

function findMin(p) {
    var a = parseFloat(document.getElementById("a").value);
    var b = parseFloat(document.getElementById("b").value);
    var c1 = parseFloat(document.getElementById("c").value);

    var currentMinX = p.x;
    for (var i=0; i < 10; i++) {
        // Funktionswert
        var fx = -2.0*p.x+2.0*currentMinX-2.0*p.y*getDValue(currentMinX) +gedSquaredValueD(currentMinX);
        var fxd =         2.0            -2.0*p.y*getDDValue(currentMinX)+gedSquaredValueDD(currentMinX);
        if (Math.abs(fxd) < 0.0001) {
            return currentMinX;
        }

        // x_{n+1} = x_n - f(x_n)/f'(x_n) wenn x gesucht, sodass f(x) = 0 gilt
        currentMinX -= fx / fxd;
    }
    return currentMinX;
}

function getDist(p, minX) {
    var minY = getValue(minX);
    return euklideanDist({"x":minX, "y":minY}, {"x":p.x, "y":p.y});
}

/*******************************************************************/
/* Start / Update                                                  */
/*******************************************************************/
function drawBoard(canvas, mouseCoords, radius) {
    var context = canvas.getContext('2d');
    context.canvas.width  = window.innerWidth - 50;
    context.canvas.height = window.innerHeight - 120;
    context.clearRect(0, 0, canvas.width, canvas.height);

    drawQuadraticFunction(canvas);
    if (document.getElementById("pDistance").checked) {
        var add = parseInt(document.getElementById("density").value)+10;
        for (var x=0; x < canvas.width; x+=add) {
            for (var y=0; y < canvas.height; y+=add) {
                var dist = getDist({"x":r(x,true), "y":r(y,false)}, findMin({"x":r(x,true), "y":r(y,false)}));
                context.fillStyle = getColor(dist,0.5);
                context.fillRect(x, y, add/2, add/2);
            }
        }
    }
}

function updateBoard(){
    var canvas = document.getElementById("myCanvas");
    STRETCH_X = parseFloat(document.getElementById("STRETCH_X").value);
    STRETCH_Y = parseFloat(document.getElementById("STRETCH_Y").value);
    X_OFFSET = parseFloat(document.getElementById("X_OFFSET").value);
    Y_OFFSET = parseFloat(document.getElementById("Y_OFFSET").value);
    drawBoard(canvas, {"x":0,"y":0}, INITIAL_RADIUS);
}

var canvas = document.getElementById("myCanvas");
var context = canvas.getContext("2d");
drawBoard(canvas, {"x":0,"y":0}, INITIAL_RADIUS);
setCursorByID("myCanvas", "crosshair");

/** get the current position of the mouse */
function getMouseCoords(canvas, evt) {
    var rect = canvas.getBoundingClientRect();
    return {
        "x": evt.clientX - rect.left,
        "y": evt.clientY - rect.top
    };
}

/** event listeners */
canvas.addEventListener('mousemove',
    function (evt) {
        var mouseCoords = getMouseCoords(canvas, evt);
        drawBoard(canvas, mouseCoords, 10);
        // draw coordinates next to mouse
        context.fillStyle = "blue";
        context.font = "bold 16px Arial";
        var x = r(mouseCoords.x, true).toFixed(3);
        var y = r(mouseCoords.y, false).toFixed(3);
        context.fillText("(" + x + ", " + y + ")", mouseCoords.x + 5, mouseCoords.y - 5);
        var minX = findMin({"x":x, "y":y});
        var minY = getValue(minX);
        context.beginPath();
        context.moveTo(c(minX, true), c(minY, false), false);
        context.lineTo(mouseCoords.x, mouseCoords.y, false);
        context.stroke();
        var minRadius = getDist({"x":x, "y":y}, minX);
        
        /* Draw circle */
        drawEllipse(mouseCoords.x, mouseCoords.y, minRadius*STRETCH_X, minRadius*STRETCH_Y);
    }, false);
