from cgi import print_directory
from tkinter import messagebox
from tkinter import ttk
from tkinter import *
import json

class mortgage:
    def __init__(self):
        self.root=Tk()
        self.root.title('Mortgage Application')
        self.root.geometry("600x500")
        self.root.configure(bg="#96c3eb")
        self.create_JSON()
        self.authenticate()

    def create_JSON(self):
        try:
            with open('mortgage.json', 'r') as f:
                self.data = json.load(f)
        except IOError:
            self.data = {}
            with open("mortgage.json", "w") as f:
                json.dump(self.data, f)
                f.close()

    def authenticate(self):
            self.c = Canvas(self.root,bg="#96c3eb",bd=0, highlightthickness=0, relief='ridge').place(x = 0,y = 0,width = 600,height = 500)
            Label(self.c,text='Mortgage Loan Application',font=("Georgia 13 bold",30),bg="#96c3eb").place(x=70,y=20)
            Label(self.c,text='Enter Username',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=100)   
            Label(self.c,text='Enter Password: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=150)
            Label(self.c,text='Confirm Password: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=200)
            self.log_user = StringVar()
            self.log_pass_1 = StringVar()
            self.log_pass_2 = StringVar()
            Entry(self.c,textvariable=self.log_user).place(x = 250,y = 100,width = 175,height = 27)
            Entry(self.c,textvariable=self.log_pass_1).place(x = 250,y = 150,width = 175,height = 27)
            Entry(self.c,textvariable=self.log_pass_2).place(x = 250,y = 200,width = 175,height = 27)
            Button(self.c,text='Login/Create Account',relief = "groove",bg="#96c3eb",font=("Georgia 13 bold",14),command=self.confirm).place(x=150,y=250,width=200,height=40)
            Button(self.c,text='Quit',relief = "groove",bg="#96c3eb",font=("Georgia 13 bold",14),command=self.root.destroy).place(x=150,y=300,width=200,height=40)
    def confirm(self):
            if self.log_pass_1.get() == self.log_pass_2.get():
                if self.log_pass_1.get() != "" or self.log_pass_2.get() != "" or self.log_user.get() != "" :
                    if self.log_user.get() in self.data:
                        messagebox.showinfo("Welcome", f"Welcome back {self.log_user.get()}")
                        self.display()
                    elif self.log_user.get() not in self.data:
                        self.res = messagebox.askquestion('Confirmation', 'This username is not registered!\nDo you want to create new account?')
                        if self.res == "yes":
                            messagebox.showinfo("Successful", f"New Account has been created")
                            self.create_widgets()
                        else:
                            self.authenticate()
                else:
                    messagebox.showerror("Error", f"The inputs cannot be empty")
            else:
                messagebox.showerror("Error", f"The passwords do not match")

    def create_widgets(self):
        self.a = Canvas(self.root,bg="#96c3eb",bd=0, highlightthickness=0, relief='ridge').place(x = 0,y = 0,width = 600,height = 500)
        Label(self.a,text='Mortgage Loan Application',font=("Georgia 13 bold",30),bg="#96c3eb").place(x=70,y=20)   
        Label(self.a,text='Enter your Name: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=100)
        Label(self.a,text='Enter your Age: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=130)
        Label(self.a,text='Enter your Credit Score: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=160)
        Label(self.a,text='Enter your Down Payment: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=190)
        Label(self.a,text='Enter your Monthly Income: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=220)
        Label(self.a,text='Enter your Monthly Expense: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=250)
        Label(self.a,text='Enter your Loan Ammount: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=280)
        
        self.name = StringVar()
        self.age = IntVar()
        self.C_score = IntVar()
        self.D_payment = IntVar()
        self.M_Income = IntVar()
        self.M_expense = IntVar()
        self.L_amount = IntVar()

        Entry(self.a,textvariable=self.name).place(x = 300,y = 100,width = 175,height = 27)
        Entry(self.a,textvariable=self.age).place(x = 300,y = 130,width = 175,height = 27)
        Entry(self.a,textvariable=self.C_score).place(x = 300,y = 160,width = 175,height = 27)
        Entry(self.a,textvariable=self.D_payment).place(x = 300,y = 190,width = 175,height = 27)
        Entry(self.a,textvariable=self.M_Income).place(x = 300,y = 220,width = 175,height = 27)
        Entry(self.a,textvariable=self.M_expense).place(x = 300,y = 250,width = 175,height = 27)
        Entry(self.a,textvariable=self.L_amount).place(x = 300,y = 280,width = 175,height = 27)
        Button(self.a,text='Apply',relief = "groove",bg="#96c3eb",font=("Georgia 13 bold",14),command=self.status).place(x=150,y=350,width=200,height=40)
        Button(self.a,text='Quit',relief = "groove",bg="#96c3eb",font=("Georgia 13 bold",14),command=self.root.destroy).place(x=150,y=400,width=200,height=40)

    def status(self):
        self.dti = (self.M_expense.get()/self.M_Income.get())*100
        if self.age.get() < 18 or self.dti > 40 or (self.C_score.get() < 600 and self.L_amount > 750000) or (self.C_score.get() < 550 and self.L_amount > 700000) or self.C_score.get() < 450:
            messagebox.showinfo("Rejected", f"Your Application has been rejected")
        else:
            self.range_1 = [i for i in range(451,550)]
            self.range_2 = [i for i in range(550,600)]
            self.range_3 = [i for i in range(600,650)]
            self.range_4 = [i for i in range(650,700)]
            if self.C_score.get() > 700:
                self.I_rate = 4
            if self.C_score.get() in self.range_1:
                self.I_rate = 7
            if self.C_score.get() in self.range_2:
                self.I_rate = 6
            if self.C_score.get() in self.range_3:
                self.I_rate = 5.5
            if self.C_score.get() in self.range_4:
                self.I_rate = 5

            monthly_rate = self.I_rate / 100 / 12
            payment = (monthly_rate / (1 - (1 + monthly_rate)**(-360))) * self.L_amount.get()
            payment = f"{payment:,.2f}"
            due_amount = self.L_amount.get()-self.D_payment.get()
            self.data[self.log_user.get()] = [{"Password":self.log_pass_1.get()},
            {"Name":self.name.get()},
            {"Interest Rate":self.I_rate},
            {"Total Due": due_amount},
            {"Monthly Payment": payment}]
            with open("mortgage.json", "w") as f:
                json.dump(self.data, f)
                f.close() 
        self.display()
    
    def display(self):
        self.b = Canvas(self.root,bg="#96c3eb",bd=0, highlightthickness=0, relief='ridge').place(x = 0,y = 0,width = 800,height = 500)
        with open('mortgage.json', 'r') as f:
            json_object = json.load(f)
            f.close()
        self.p_amount = IntVar()

        Entry(self.b,textvariable=self.p_amount).place(x = 300,y = 100,width = 175,height = 27)
        Label(self.b,text='Mortgage Loan Application',font=("Georgia 13 bold",30),bg="#96c3eb").place(x=70,y=20)   
        Label(self.b,text='Enter your Payment: ',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=100)
        Label(self.b,text=f'Name: {json_object[self.log_user.get()][1]["Name"]}',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=160)
        Label(self.b,text=f'Interest Rate: {json_object[self.log_user.get()][2]["Interest Rate"]}%',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=190)
        Label(self.b,text=f'Total Due: ${json_object[self.log_user.get()][3]["Total Due"]}',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=220)
        Label(self.b,text=f'Monthly Payment: ${json_object[self.log_user.get()][4]["Monthly Payment"]}',font=("Georgia 13 bold",14),bg="#96c3eb").place(x=20,y=250)
        Button(self.b,text='Log Out',relief = "groove",bg="#96c3eb",font=("Georgia 13 bold",14),command=self.authenticate).place(x=150,y=350,width=200,height=40)
        Button(self.b,text='Pay',relief = "groove",bg="#96c3eb",font=("Georgia 13 bold",14),command=self.pay).place(x=150,y=300,width=200,height=40)
    def pay(self):
        with open('mortgage.json', 'r') as f:
            json_object = json.load(f)
            f.close()
        x = json_object[self.log_user.get()][3]["Total Due"]
        x = x - self.p_amount.get()
        json_object[self.log_user.get()][3]["Total Due"] = x
        print(json_object)
        with open("mortgage.json", "w") as f:
            json.dump(json_object, f)
            f.close() 
        messagebox.showinfo("Congratulations", f"Your Payment was submitted")


a = mortgage()
mainloop()
