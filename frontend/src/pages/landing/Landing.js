import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { GoogleLogin } from "@react-oauth/google";
import { jwtDecode } from "jwt-decode";
import Cookies from "js-cookie"; // or import cookie from 'cookie';
import axios from "axios";

function Landing() {
  const [loggedIn, setLoggedIn] = React.useState(false);
  const navigate = useNavigate();
  useEffect(() => {
    if (Cookies.get("storedCredential") === undefined) {
      return;
    }
    const decoded = jwtDecode(Cookies.get("storedCredential"));
    if (decoded.name === Cookies.get("Name")) {
      setLoggedIn(true);
    }
  }, []);

  // ...

  const handleGoogleSignin = async (credentialResponse) => {
    const decoded = jwtDecode(credentialResponse.credential);

    try {
      const response = await axios.put(
        "http://localhost:8080/api/v1/user/authUser",
        {
          name: decoded.name,
          email: decoded.email,
        }
      );

      if (response.status === 200) {
        const uid = response.data; // Assuming the response contains the uid
        // Store the uid on the frontend
        // You can use state or any other method to store the uid
        // For example, using useState hook:

        console.log("Decoded:", decoded);
        Cookies.set("Name", decoded.name, {
          expires: 365,
        });
        Cookies.set("storedCredential", credentialResponse.credential, {
          expires: 365,
        });
        Cookies.set("uid", uid, {
          expires: 365,
        });
        console.log("UID: ", uid);
        setLoggedIn(true);
      } else {
        console.log("Failed to authenticate user");
      }

      // window.location.reload();
    } catch (error) {
      console.log("Failed to authenticate user", error);
    }
  };

  return (
    <div className=" w-11/12 pb-12 mt-16 top-1/2 mx-auto bg-mainBg bg-cover bg-center p-4 border-8 border-mainCol flex flex-row">
      <div className="w-full sm:w-1/2 px-8 sm:flex sm:flex-col gap-4 justify-center">
        <h1 className="font-bold text-4xl sm:text-7xl sm:tracking-wider uppercase">
          Welcome to BITSBIDS
        </h1>
        {loggedIn ? (
          <></>
        ) : (
          <GoogleLogin
            onSuccess={handleGoogleSignin}
            onError={() => {
              console.log("Login Failed");
            }}
          />
        )}
        <p className=" capitalize text-md">
          Your exclusive marketplace for all your shopping needs. Bid, buy and
          sell anonymously - Start shopping today!
        </p>
        <div className="flex flex-row gap-12 mt-4">
          <button
            onClick={() => {
              navigate("/shop");
            }}
            className="bg-mainCol px-6 py-2 text-white font-bold text-md"
          >
            Start Shopping
          </button>
          <button
            onClick={() => {
              navigate("/sell");
            }}
            className="bg-mainCol px-6 py-2 text-white font-bold text-md"
          >
            Start Selling
          </button>
        </div>
      </div>
      <div className="sm:w-1/2 w-full">
        <img src="landing.png" alt="landing" className="mx-auto w-3/4 mt-12" />
      </div>
    </div>
  );
}

export default Landing;
