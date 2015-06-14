[CodebookSet cbs [FeatureSet fs]] add cb dummy 2 1 NO
DistribSet dss cbs ; dss add ds1 cb ; dss add ds2 cb ; dss add ds3 cb

dss:ds1 configure -val {0.3 0.7} -count 2
dss:ds2 configure -val {0.4 0.6} -count 3
dss:ds3 configure -val {0.8 0.2} -count 3