import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="bg-mainCol text-2xl tracking-wide flex flex-row justify-between py-6">
      <div className="text-left ml-8 font-extrabold">BITSBIDS</div>
      <div className=" items-end flex flex-row gap-4 mr-16 uppercase font-bold">
        <Link className="">Shop</Link>
        <Link className="">Sell</Link>
        <Link className="">Chat</Link>
        <Link className="">Dashboard</Link>
      </div>
    </nav>
  );
}

export default Navbar;
