import React from "react";
import { Link } from "react-router-dom";

function Landing() {
  return (
    <div className=" w-11/12 pb-12 mt-16 top-1/2 mx-auto bg-mainBg bg-cover bg-center p-4 border-8 border-mainCol flex flex-row">
      <div className="w-full sm:w-1/2 px-8 sm:flex sm:flex-col gap-4 justify-center">
        <h1 className="font-bold text-4xl sm:text-7xl sm:tracking-wider uppercase">
          Welcome to BITSBIDS
        </h1>
        <p className=" capitalize text-md">
          Your exclusive marketplace for all your shopping needs. Bid, buy and
          sell anonymously - Start shopping today!
        </p>
        <div className="flex flex-row gap-12 mt-4">
          <button className="bg-mainCol px-6 py-2 text-white font-bold text-md">
            Start Shopping
          </button>
          <button className="bg-mainCol px-6 py-2 text-white font-bold text-md">
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
