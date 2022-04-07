#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr  6 17:25:45 2022

@author: Alil
"""

import math 
amount = float (input("Enter an amount for the money bond: $"))
x = int(input("Enter number of years: "))
i = 0.05
moneybond = amount*math.pow((1+i), x);
print("The money bond value after ",x," years with a 5% increase each year is: $", round(moneybond, 2))