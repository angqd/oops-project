import React, { useEffect, useState } from "react";
import Cookies from "js-cookie";
import axios from "axios";

const BuyerDashboard = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const uid = Cookies.get("uid");
    fetch("http://localhost:8080/api/v1/products/buyerDash", {
      method: "POST",
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

  return (
    <div>
      <ul>
        {products.map((product) => (
          <li key={product.id} className="text-5xl">
            {product.name}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BuyerDashboard;
