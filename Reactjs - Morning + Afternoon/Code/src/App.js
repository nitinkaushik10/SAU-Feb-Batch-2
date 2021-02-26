import "./App.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { AddBook } from "./components/AddBook";
import { BookDetails } from "./components/BookDetails";
import { SearchBook } from "./components/SearchBook.js";
import { Container, Nav, Navbar } from "react-bootstrap";

function App() {
  return (
    <Router>
    
      <div  class="d-flex  justify-content-center  hello">  
       <Link class="btn btn-info col-md-3" to="/add">Add</Link>
       <Link class="btn btn-danger mx-5 col-md-3"to="/list">Search</Link>
       </div>
     

      <Container>
        <Switch>
          
          <Route path="/list">
            <SearchBook />{" "}
          </Route>
          <Route path="/add">
            <AddBook />
          </Route>
          <Switch>
            <Route path="/detail/:id" children={<BookDetails />} />
          </Switch>
        </Switch>
      </Container>
    </Router>
  );
}

export default App;
