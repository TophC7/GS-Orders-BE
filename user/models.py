from flask import Flask, jsonify, redirect, request, session
from passlib.hash import pbkdf2_sha256 as sha2
from app import db
import uuid


class User:
    def start_session(self, user):

        del user["password"]

        session["logged_in"] = True
        session["user"] = user
        return jsonify(user), 200

    def signup(self):

        # print(request.form)
        # Create User Obj
        user = {
            "_id": uuid.uuid4().hex,
            "name": request.form.get("name"),
            "email": request.form.get("email"),
            "password": request.form.get("password"),
        }

        # Encrypt Password
        user["password"] = sha2.encrypt(user["password"])

        # Check for Dupes
        if db.users.find_one({"email": user["email"]}):
            return jsonify({"error": "Email Already Exists in Database"}), 400

        if db.users.insert_one(user):
            return self.start_session(user)

        return jsonify({"error": "Signup failed"}), 500

    def signout(self):
        session.clear()
        return redirect("/")
