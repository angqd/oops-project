import React from "react";
import { Link, useLocation } from "react-router-dom";

function Navbar() {
  const location = useLocation();

  return (
    <nav className="bg-mainCol text-2xl tracking-wide flex flex-row justify-between py-6">
      <Link to={"/"}>
        <div className="text-left ml-8 font-extrabold">BITSBIDS</div>
      </Link>
      <div className="items-end flex flex-row gap-4 mr-16 uppercase font-bold">
        <Link
          to={"/shop"}
          className={`hover:text-white hover:underline hover:underline-offset-8 transition-all ${
            location.pathname === "/shop" ? "text-white" : ""
          }`}
        >
          Shop
        </Link>
        <Link
          to={"/sell"}
          className={`hover:text-white hover:underline hover:underline-offset-8 transition-all ${
            location.pathname === "/sell" ? "text-white" : ""
          }`}
        >
          Sell
        </Link>
        <Link
          to={"/chat"}
          className={`hover:text-white hover:underline hover:underline-offset-8 transition-all ${
            location.pathname === "/chat" ? "text-white" : ""
          }`}
        >
          Chat
        </Link>
        <Link
          to={"/dashboard"}
          className={`hover:text-white hover:underline hover:underline-offset-8 transition-all ${
            location.pathname.includes("Dashboard") ? "text-white" : ""
          }`}
        >
          Dashboard
        </Link>
      </div>
    </nav>
  );
}

export default Navbar;
