# -*- coding: utf-8 -*-
"""
Created on Thu Apr 14 20:24:01 2022

@author: jmedz
"""

import requests
class Currency_convertor:
   # dictionary to store the conversion rates
    rates = {} 
    def __init__(self, url):
        data = requests.get(url).json()
  
        # data extraction
        self.rates = data["rates"] 
  
    #conversion rates math
    def convert(self, amount1, amount2, amount):
        iamount = amount
        if amount1 != 'EUR' :
            amount = amount / self.rates[amount1]
  
        #format
        amount = round(amount * self.rates[amount2], 2)
        print('{} {} = {} {}'.format(iamount, amount1, amount, amount2))
  
# function to call out
if __name__ == "__main__":
  
    #API To use
    url = ('http://data.fixer.io/api/latest?access_key=7effd460e32430297cb4ecf8bb1c5943')  
    c = Currency_convertor(url)
    country1 = input("Initial Country Currency: ")
    country2 = input("Desired Country Currency to be converted to: ")
    amount = int(input("Amount to be converted: "))
  
    c.convert(country1, country2, amount)