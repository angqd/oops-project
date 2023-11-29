import React, { useEffect, useState } from "react";
import Cookies from "js-cookie";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import axios from "axios";

function Sell() {
  const [loggedIn, setLoggedIn] = React.useState(false);
  const [Uname, setUName] = useState("");
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    if (Cookies.get("storedCredential") === undefined) {
      navigate("/");
      return;
    }
    const decoded = jwtDecode(Cookies.get("storedCredential"));
    if (decoded.name === Cookies.get("Name")) {
      setLoggedIn(true);
      setUName(decoded.name);
    } else {
      navigate("/");
    }
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const createdAt = new Date().toISOString();
    const uid = 1;

    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/products",
        {
          uid,
          name,
          description,
          createdAt,
        }
      );
      console.log(response.data);
      alert("Added successfully");
      setName("");
      setDescription("");
    } catch (error) {
      console.error(error);
      // Handle error
    }
  };

  return (
    <div className="flex flex-row justify-evenly w-11/12 pb-12 mt-16 mx-auto bg-mainBg bg-cover bg-center py-16 px-20 border-8 border-mainCol">
      <div className="p-16 bg-gray-400 bg-opacity-50 flex items-center">
        {/* SVG Icons */}
      </div>
      <div className="flex items-center">
        <div className=" bg-white border-4 border-mainCol p-8 w-fit h-fit">
          <form onSubmit={handleSubmit}>
            <h1>Product Name</h1>
            <input
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
            <h1>Description</h1>
            <input
              type="text"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
            <button type="submit">Submit</button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Sell;
