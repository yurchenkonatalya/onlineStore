import React from "react";
import { Navbar, Container, Nav, Row, Form, FormControl, Button } from "react-bootstrap";
import logo from '../img/logo.ico';

function Header(){
    return(
      <Navbar bg="dark" expand="dark" className="w-100">
      <Container className="d-flex justify-content-start w-100" fluid>
      
      <Navbar.Brand href="#home" className="ms-5 w-10">
      <img
        src={logo}
        width="100"
        height="50"
        className="d-inline-block align-top"
        alt="React Bootstrap logo"
      />
    </Navbar.Brand>
    <Form className="ms-5 w-50" >
  <Form.Group className="w-75 d-flex justify-content-start">
    <Form.Control  placeholder="Товар, услуга" />
    <Button variant="outline-success" className="ms-2 w-25">Find</Button>
  </Form.Group>
  </Form>
      </Container>
    </Navbar>
  )
}

export default Header;

