import React, { useEffect, useState, useRef } from "react";
import Cookies from "js-cookie";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import axios from "axios";

function Sell() {
  const [loggedIn, setLoggedIn] = React.useState(false);
  const [Uname, setUName] = useState("");
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [currentBid, setCurrentBid] = useState("");
  const [endsAt, setEndsAt] = useState("");
  const [image, setImage] = useState(null);
  const [image2, setImage2] = useState(null);
  const [image3, setImage3] = useState(null);
  const [tImage, setImgUrl] = useState(null);
  const [confirmed, setConfirmed] = useState(false);
  const [file, setFile] = useState(null);
  const formData1 = new FormData();
  const formData2 = new FormData();
  const formData3 = new FormData();
  const navigate = useNavigate();
  const fileInputRef = useRef(null);
  const fileInputRef2 = useRef(null);
  const fileInputRef3 = useRef(null);

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
    if (!confirmed) {
      alert("Please confirm the image upload before submitting.");
      return;
    }
    const createdAt = new Date().toISOString();
    const uid = Cookies.get("uid");
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/products/add",
        {
          uid,
          name,
          description,
          currentBid,
          endsAt,
          createdAt,
          tImage,
        }
      );
      console.log(tImage);
      console.log(response.data);
      alert("Added successfully");
      setName("");
      setDescription("");
      setCurrentBid("");
      setEndsAt("");
      setImage(null);
    } catch (error) {
      console.error(error);
    }
  };

  const handleImageUpload = async (e) => {
    const file = e.target.files[0];
    setImage(e.target.files[0]);
  };
  const confirmImg = async () => {
    formData1.append("file", image);
    formData1.append("upload_preset", "k4vaqdxx");
    try {
      const response = await fetch(
        "https://api.cloudinary.com/v1_1/dofuqsxph/image/upload",
        {
          method: "POST",
          body: formData1,
        }
      );
      const data = await response.json();
      console.log(data.url);
      setImgUrl(data.url);
      setConfirmed(true);
      alert("Image uploaded successfully");
    } catch (error) {
      console.error(error);
      alert("Failed to upload image");
    }
  };

  const handleImage2Upload = async (e) => {
    const file = e.target.files[0];
    setImage2(e.target.files[0]);
  };
  const confirmImg2 = async () => {
    formData2.append("file", image2);
    formData2.append("upload_preset", "k4vaqdxx");
    try {
      const response = await fetch(
        "https://api.cloudinary.com/v1_1/dofuqsxph/image/upload",
        {
          method: "POST",
          body: formData1,
        }
      );
      const data = await response.json();
      console.log(data.url);
      setImgUrl(data.url);
      alert("Image uploaded successfully");
    } catch (error) {
      console.error(error);
      alert("Failed to upload image");
    }
  };
  const handleImage3Upload = async (e) => {
    const file = e.target.files[0];
    setImage3(e.target.files[0]);
  };
  const confirmImg3 = async () => {
    formData3.append("file", image3);
    formData3.append("upload_preset", "k4vaqdxx");
    try {
      const response = await fetch(
        "https://api.cloudinary.com/v1_1/dofuqsxph/image/upload",
        {
          method: "POST",
          body: formData1,
        }
      );
      const data = await response.json();
      console.log(data.url);
      setImgUrl(data.url);
      alert("Image uploaded successfully");
    } catch (error) {
      console.error(error);
      alert("Failed to upload image");
    }
  };

  const handleDivClick = (fileInputRef) => {
    fileInputRef.current.click();
  };

  return (
    <div className="flex flex-row justify-evenly w-11/12 pb-12 mt-16 mx-auto bg-mainBg bg-cover bg-center py-16 px-20 border-8 border-mainCol">
      <div className="w-1/2 align-middle flex flex-col gap-2 items-center">
        <div
          className={`p-16 ${
            image ? "bg-transparent" : "bg-gray-400 bg-opacity-50"
          } w-3/4 h-full flex flex-row justify-center items-center`}
          onClick={() => {
            handleDivClick(fileInputRef);
          }}
        >
          {image ? (
            <img
              src={URL.createObjectURL(image)}
              alt="Uploaded"
              className="w-full h-full object-contain"
            />
          ) : (
            <>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth={1}
                stroke="currentColor"
                className="w-12 h-12"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M12 4.5v15m7.5-7.5h-15"
                />
              </svg>

              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth={0.5}
                stroke="currentColor"
                className="w-1/2 h-1/2 text-gray-800"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M2.25 15.75l5.159-5.159a2.25 2.25 0 013.182 0l5.159 5.159m-1.5-1.5l1.409-1.409a2.25 2.25 0 013.182 0l2.909 2.909m-18 3.75h16.5a1.5 1.5 0 001.5-1.5V6a1.5 1.5 0 00-1.5-1.5H3.75A1.5 1.5 0 002.25 6v12a1.5 1.5 0 001.5 1.5zm10.5-11.25h.008v.008h-.008V8.25zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z"
                />
              </svg>
            </>
          )}
        </div>
        <button
          onClick={confirmImg}
          className="border-2 border-mainCol bg-white text-mainCol w-fit px-2 py-1 hover:bg-mainCol hover:text-white transition-all"
        >
          Confirm Image
        </button>
        <div
          className={`p-16 ${
            image2 ? "bg-transparent" : "bg-gray-400 bg-opacity-50"
          } w-3/4 h-full flex flex-row justify-center items-center`}
          onClick={() => {
            handleDivClick(fileInputRef2);
          }}
        >
          {image2 ? (
            <img
              src={URL.createObjectURL(image2)}
              alt="Uploaded"
              className="w-full h-full object-contain"
            />
          ) : (
            <>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth={1}
                stroke="currentColor"
                className="w-12 h-12"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M12 4.5v15m7.5-7.5h-15"
                />
              </svg>

              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth={0.5}
                stroke="currentColor"
                className="w-1/2 h-1/2 text-gray-800"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M2.25 15.75l5.159-5.159a2.25 2.25 0 013.182 0l5.159 5.159m-1.5-1.5l1.409-1.409a2.25 2.25 0 013.182 0l2.909 2.909m-18 3.75h16.5a1.5 1.5 0 001.5-1.5V6a1.5 1.5 0 00-1.5-1.5H3.75A1.5 1.5 0 002.25 6v12a1.5 1.5 0 001.5 1.5zm10.5-11.25h.008v.008h-.008V8.25zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z"
                />
              </svg>
            </>
          )}
        </div>
        <button className="border-2 border-mainCol bg-white text-mainCol w-fit px-2 py-1 hover:bg-mainCol hover:text-white transition-all">
          Confirm Image
        </button>
        <div
          className={`p-16 ${
            image3 ? "bg-transparent" : "bg-gray-400 bg-opacity-50"
          } w-3/4 h-full flex flex-row justify-center items-center`}
          onClick={() => {
            handleDivClick(fileInputRef3);
          }}
        >
          {image3 ? (
            <img
              src={URL.createObjectURL(image3)}
              alt="Uploaded"
              className="w-full h-full object-contain"
            />
          ) : (
            <>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth={1}
                stroke="currentColor"
                className="w-12 h-12"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M12 4.5v15m7.5-7.5h-15"
                />
              </svg>

              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth={0.5}
                stroke="currentColor"
                className="w-1/2 h-1/2 text-gray-800"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  d="M2.25 15.75l5.159-5.159a2.25 2.25 0 013.182 0l5.159 5.159m-1.5-1.5l1.409-1.409a2.25 2.25 0 013.182 0l2.909 2.909m-18 3.75h16.5a1.5 1.5 0 001.5-1.5V6a1.5 1.5 0 00-1.5-1.5H3.75A1.5 1.5 0 002.25 6v12a1.5 1.5 0 001.5 1.5zm10.5-11.25h.008v.008h-.008V8.25zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z"
                />
              </svg>
            </>
          )}
        </div>
        <button className="border-2 border-mainCol bg-white text-mainCol w-fit px-2 py-1 hover:bg-mainCol hover:text-white transition-all">
          Confirm Image
        </button>
        <input
          type="file"
          accept="image/*"
          ref={fileInputRef}
          style={{ display: "none" }}
          onChange={handleImageUpload}
        />
        <input
          type="file"
          accept="image/*"
          ref={fileInputRef2}
          style={{ display: "none" }}
          onChange={handleImage2Upload}
        />
        <input
          type="file"
          accept="image/*"
          ref={fileInputRef3}
          style={{ display: "none" }}
          onChange={handleImage3Upload}
        />
      </div>

      <div className=" bg-transparent shadow-xl border-4 border-mainCol py-8 px-12 w-1/2 h-fit">
        <form onSubmit={handleSubmit} className="flex flex-col gap-2">
          <h1 className="font-bold text-lg">Product Name</h1>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            className="border-2 border-gray-300 py-1 px-2"
          />
          <h1 className="font-bold text-lg">Description</h1>
          <input
            type="text"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            className="border-2 border-gray-300 py-1 px-2"
          />
          <h1 className="font-bold text-lg">Current Bid</h1>
          <input
            type="text"
            value={currentBid}
            onChange={(e) => setCurrentBid(e.target.value)}
            className="border-2 border-gray-300 py-1 px-2"
          />
          <h1 className="font-bold text-lg">Ends At</h1>
          <input
            type="datetime-local"
            value={endsAt}
            onChange={(e) => setEndsAt(e.target.value)}
            className="border-2 border-gray-300 py-1 px-2 uppercase"
          />
          <button
            type="submit"
            className="border-2 hover:border-mainCol bg-mainCol hover:bg-white text-white hover:text-mainCol py-2 px-2 mt-4"
          >
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}

export default Sell;
