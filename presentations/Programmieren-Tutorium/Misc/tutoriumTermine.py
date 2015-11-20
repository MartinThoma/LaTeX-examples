#!/usr/bin/env python
import datetime

tmp_day = datetime.date.today()       # von
lastday = datetime.date(2014, 2, 10)  # bis (Vorlesungsende?)

while tmp_day < lastday:
    if tmp_day.weekday() == 0:
        print tmp_day.strftime('%d.%m.%Y')
    tmp_day += datetime.timedelta(days=1)
