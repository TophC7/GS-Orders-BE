from functools import wraps
from flask import Flask, redirect, render_template, session
import pymongo

app = Flask(__name__)
app.secret_key = b"\x98=\xa0V\xcd\x95e\xa43w\x11\xde\x13\xd2i\xa0"

# Database
client = pymongo.MongoClient("localhost", 27017)
db = client.user_login_system

# Decorators
def login_required(f):
    @wraps(f)
    def wrap(*args, **kwargs):
        if "logged_in" in session:
            return f(*args, **kwargs)
        else:
            return redirect("/")

    return wrap


# Routes
from user import routes


@app.route("/")
def home():
    return render_template("home.html")


@app.route("/dashboard/")
@login_required
def dashboard():
    return render_template("dashboard.html")
