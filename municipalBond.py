#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Apr 14 14:06:46 2022

@author: Alil
"""

amount = float(input("Enter the amount of the loan given to you. $"))
period = 6
print("You have to pay the interest every ",period," months until the bond is paid back to the bond holder.")
payment = 0.08 * amount
print("The price of the interest is: $",payment)
