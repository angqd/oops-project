import React, { useEffect, useState } from "react";
import Cookies from "js-cookie";
import axios from "axios";

const BuyerDashboard = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const uid = Cookies.get("uid");
    fetch("http://localhost:8080/api/v1/products/buyerDash", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        uid: uid,
      }),
    })
      .then((response) => response.json())
      .then((data) => {
        setProducts(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const calculateTimeRemaining = (endsAt) => {
    const currentTime = new Date();
    const endsAtTime = new Date(endsAt);
    const timeDifference = endsAtTime - currentTime;

    const days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
    const hours = Math.floor(
      (timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
    );
    const minutes = Math.floor(
      (timeDifference % (1000 * 60 * 60)) / (1000 * 60)
    );

    return `${days} days ${hours} hours ${minutes} minutes`;
  };

  return (
    <div className="flex flex-row sm:grid-cols-2 gap-6 w-11/12 pb-12 mt-16 mx-auto bg-mainBg bg-cover bg-center py-16 px-20 border-8 border-mainCol">
      <div className="w-1/2">
        <h1 className="font-bold text-4xl sm:text-4xl sm:tracking-wider uppercase text-center mt-12 mb-12">
          Ongoing
        </h1>
        <ul className="flex flex-col gap-6">
          {products.map((product) => {
            if (!product.sold) {
              const borderClass = product.freeze
                ? "border-4 border-green-500"
                : "border-4 border-transparent";
              return (
                <li
                  key={product.id}
                  className={`flex flex-row items-center ${borderClass} py-6 px-6 shadow-lg`}
                >
                  <img
                    src={product.tImage ? product.tImage : ""}
                    className="w-24 h-24 mr-4 object-contain"
                  />
                  <div className="flex flex-col">
                    <h2 className="text-xl font-bold">{product.name}</h2>
                    <p>
                      Current Bid:{" "}
                      <span className="font-bold">₹{product.currentBid}</span>
                    </p>
                    <p>
                      Time Remaining:{" "}
                      <span className="font-bold">
                        {calculateTimeRemaining(product.endsAt)}
                      </span>
                    </p>
                  </div>
                </li>
              );
            }
            return null;
          })}
        </ul>
      </div>
      <div className="w-1/2">
        <h1 className="font-bold text-4xl sm:text-4xl sm:tracking-wider uppercase text-center mt-12">
          Completed
        </h1>
        <ul>
          {products.map((product) => {
            if (product.sold) {
              return (
                <li
                  key={product.id}
                  className="flex flex-row items-center border-4 border-mainCol py-4 px-6"
                >
                  <img
                    src={product.tImage ? product.tImage : ""}
                    className="w-12 h-12 mr-4 object-contain"
                  />
                  <div className="flex flex-col">
                    <h2 className="text-xl font-bold">{product.name}</h2>
                    <p>Current Bid: {product.currentBid}</p>
                    <p>
                      Time Remaining: {calculateTimeRemaining(product.endsAt)}
                    </p>
                  </div>
                </li>
              );
            }
            return null;
          })}
        </ul>
      </div>
    </div>
  );
};

export default BuyerDashboard;
