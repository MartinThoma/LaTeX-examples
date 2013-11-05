#!/usr/bin/env python
import datetime

tmpDay  = datetime.date.today()     # von
lastday = datetime.date(2014,2,10)  # bis (Vorlesungsende?)

while tmpDay < lastday:
    if tmpDay.weekday() == 0:
        print tmpDay.strftime('%d.%m.%Y')
    tmpDay += datetime.timedelta(days=1)
