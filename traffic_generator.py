from numpy.random import exponential as exp
import os
import time
import random

while True:
    elephant = True if random.randint(1,20) == 1 else False
    
    if elephant:
        flow_duration = round(exp(scale=20), 2)
        bandwidth = round(1024 ** 2 * exp(scale=20))  # Mb/s
    else:
        flow_duration = round(exp(scale=1), 2)
        bandwidth = round(1024 ** 2 * exp(scale=0.1))  # Mb/s
    
    time_to_next_flow = round(exp(scale=0.05), 3)  # s
    

    port = random.randint(61001, 64000)

    time.sleep(time_to_next_flow)
    command = "iperf -c 10.0.0.2 -u -b {} -t {} -p {} &".format(bandwidth, flow_duration, port)
    print('------------------------------------------------------')
    print("Executing command: ", command)
    os.system(command)
