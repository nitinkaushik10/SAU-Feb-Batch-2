import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { insertBook } from "../redux/actions";
import { useHistory } from "react-router-dom";
import { Button, Form } from "react-bootstrap";
import "./style/CombineStyles.css";

export const AddBook = () => {
  const books = useSelector((state) => state.bookStorage) || [];
  const dispatch = useDispatch();
  const [bookName, setBookName] = useState("");
  const [bookAuthor, setBookAuthor] = useState("");
  const [bookIsbn, setBookIsbn] = useState("");
  const [bookPrice, setBookPrice] = useState("");
  let history = useHistory();

  return (
    
    <div class="cardview">
    <div
      style={{
      
        backgroundRepeat: "no-repeat",
        height: "700px",
      }}
    >
    
      <center>
        <h1></h1>
       
          <h1 class="text-success">BOOK ADD</h1>
        
      </center>
      <Form.Group controlId="formBasicEmail">
        <b>
          <Form.Label >Book Name</Form.Label>
        </b>
        <Form.Control
          onInput={(e) => setBookName(e.target.value)}
          className="trans"
          size="lg"
          type="text"
          placeholder="Enter the book name"
        />
      </Form.Group>

      <Form.Group>
        <b>
          <Form.Label >Author</Form.Label>
        </b>
        <Form.Control
          onInput={(e) => setBookAuthor(e.target.value)}
          className="trans"
          size="lg"
          type="text"
          placeholder="Enter the Author name"
        />
      </Form.Group>
      
      <Form.Group>
        <b>
          <Form.Label >ISBN Number</Form.Label>
        </b>
        <Form.Control
          onInput={(e) => setBookIsbn(e.target.value)}
          className="trans"
          size="lg"
          type="text"
          placeholder="Enter the 10 digit ISBN no."
        />
      </Form.Group>


      <Form.Group>
        <b>
          <Form.Label >Book Price</Form.Label>
        </b>
        <Form.Control
          onInput={(e) => setBookPrice(e.target.value)}
          className="trans"
          size="lg"
          type="number"
          placeholder="Enter the Book Price"
        />
      </Form.Group>


      <center>
        <Button class="btn btn-success col-md-12"
          onClick={() => {
            dispatch(insertBook(bookName, bookAuthor, bookIsbn, bookPrice));
            history.push("/list");
          }}
        >
          Add
        </Button>
      </center>
    </div>
    </div>
   
  );
};
