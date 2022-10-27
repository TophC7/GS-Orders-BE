from app import app
from user.models import User


@app.route("/user/signup", methods=["GET", "POST"])
def signup():
    return User().signup()


@app.route("/user/signout")
def signout():
    return User().signout()
