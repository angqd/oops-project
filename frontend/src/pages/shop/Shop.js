import React, { useEffect, useState } from "react";
import Cookies from "js-cookie";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import axios from "axios";

const Shop = () => {
  const [loggedIn, setLoggedIn] = React.useState(false);
  const [name, setName] = useState("");
  const [show, setShow] = useState(false);
  const [products, setProducts] = useState([]);
  const [currentBid, setCurrentBid] = useState("");
  const [pid, setPid] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    if (Cookies.get("storedCredential") === undefined) {
      navigate("/");
      return;
    }
    const decoded = jwtDecode(Cookies.get("storedCredential"));
    if (decoded.name === Cookies.get("Name")) {
      setLoggedIn(true);
      setName(decoded.name);
    } else {
      navigate("/");
    }

    fetch("http://localhost:8080/api/v1/products")
      .then((response) => response.json())
      .then((data) => {
        setProducts(data);
      })
      .catch((error) => {
        console.error("Error fetching products:", error);
      });
  }, []);

  const renderProductDetails = () => {
    const product = products.find((product) => product.id === pid);
    if (product) {
      const timeRemaining = new Date(product.endsAt).getTime() - Date.now();

      const days = Math.floor(timeRemaining / (1000 * 60 * 60 * 24));
      const hours = Math.floor(
        (timeRemaining % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)
      );
      const minutes = Math.floor(
        (timeRemaining % (1000 * 60 * 60)) / (1000 * 60)
      );

      const timeRemainingString = `${days} days, ${hours} hours, ${minutes} minutes`;

      const handleSubmit = () => {
        const uid = Cookies.get("uid");
        const data = {
          id: pid,
          currentBid: currentBid,
          buyerId: uid,
        };

        axios
          .post("http://localhost:8080/api/v1/products/edit", data)
          .then(() => {
            alert("Bid submitted successfully!");
            window.location.reload();
          })
          .catch((error) => {
            console.error("Error submitting bid:", error);
          });
      };

      return (
        <div className="w-full h-full top-0 fixed bg-opacity-50 bg-black flex justify-center items-center">
          <div className="h-3/4 w-3/4 bg-mainBg bg-cover bg-center p-4 flex flex-row">
            <button
              className="absolute top-2 right-2 text-red hover:text-white hover:rotate-180 transition-all"
              onClick={() => setShow(false)}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth={1.5}
                stroke="currentColor"
                className="w-12 h-12"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M9.75 9.75l4.5 4.5m0-4.5l-4.5 4.5M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                />
              </svg>
            </button>
            <div className="h-full w-1/2"></div>
            <div className="h-full w-1/2 flex flex-col gap-8 py-10 px-4">
              <div className="border-4 border-mainCol bg-white h-auto p-4 flex flex-col justify-evenly">
                <h1 className="font-bold text-2xl sm:text-2xl capitalize">
                  {product.name}
                </h1>
                <h1 className="text-md sm:text-md capitalize">
                  {product.description}
                </h1>
                <h1 className="text-md sm:text-lg capitalize mt-6">
                  Current bid:{" "}
                  <span className="font-bold">₹{product.currentBid}</span>
                </h1>
                <h1 className="text-md sm:text-lg capitalize">
                  Time Remaining:{" "}
                  <span className="font-bold">{timeRemainingString}</span>
                </h1>
              </div>
              <div className="h-1/2 flex flex-row gap-4">
                <div className="w-1/2 bg-white border-4 border-mainCol flex flex-col gap-2 justify-center px-2">
                  <h1 className="text-xl sm:text-xl font-bold text-center">
                    Place New Bid:
                  </h1>
                  <div className="flex flex-row justify-center">
                    <div>
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className={`w-8 h-8 minus hover:text-red hover:rotate-180 transition-all ${
                          currentBid <= product.currentBid
                            ? "disabled"
                            : "cursor-pointer"
                        }`}
                        onClick={() => {
                          if (currentBid > product.currentBid) {
                            setCurrentBid(
                              (prevBid) => prevBid - product.currentBid * 0.05
                            );
                          }
                        }}
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          d="M15 12H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
                        />
                      </svg>
                    </div>
                    <h1 className="text-lg sm:text-lg text-red text-center px-2 py-1">
                      {currentBid}
                    </h1>
                    <div>
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-8 h-8 plus hover:text-green-500 hover:rotate-180 transition-all cursor-pointer"
                        onClick={() => {
                          setCurrentBid(
                            (prevBid) => prevBid + product.currentBid * 0.05
                          );
                        }}
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          d="M12 9v6m3-3H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
                        />
                      </svg>
                    </div>
                  </div>
                  <button
                    className="bg-mainCol text-white py-2 px-8 border-2 hover:text-mainCol transition-all hover:border-mainCol hover:bg-white w-auto mx-auto"
                    onClick={handleSubmit}
                  >
                    Submit Bid
                  </button>{" "}
                </div>
                <div className="w-1/2 bg-white border-4 border-mainCol"></div>
              </div>
            </div>
          </div>
        </div>
      );
    }
    return null;
  };

  return (
    <>
      <div className="w-11/12 mt-16 top-1/2 mx-auto p-4 bg-white border-8 border-mainCol flex flex-row">
        <div>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1.5}
            stroke="currentColor"
            className="w-6 h-6"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z"
            />
          </svg>
        </div>
        <h1>FILTER</h1>
        <h1>SORT</h1>
      </div>
      <div className="w-11/12 pb-12 mt-12 top-1/2 mx-auto bg-mainBg bg-cover bg-center p-4 border-8 border-mainCol flex flex-row gap-6 justify-evenly flex-wrap">
        {products.map((product) => (
          <div
            key={product.id}
            className="p-4 transition-all cursor-pointer hover:shadow-lg"
            onClick={() => {
              setShow(true);
              setPid(product.id);
              setCurrentBid(product.currentBid);
            }}
          >
            <img src="book.jpg" alt="Book" className="h-48" />
            <h2 className="mt-2">
              Name: <span className="font-bold capitalize">{product.name}</span>
            </h2>
            <h2>
              Current Bid:{" "}
              <span className="font-bold">₹{product.currentBid}</span>
            </h2>
          </div>
        ))}
        {show && renderProductDetails()}
      </div>
    </>
  );
};

export default Shop;
