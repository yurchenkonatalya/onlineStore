import React from "react";
import { Navbar, Container, Nav, Row, Col, Form, FormControl, Button } from "react-bootstrap";
import logo from '../img/logo.ico';

function Header(){
    return(
      <Navbar bg="dark" expand="dark" className="w-100">
      <Container className="d-flex justify-content-start w-100" fluid>
      <Row className="w-100">
      <Col lg={2}>
      <Navbar.Brand href="#home">
      <img
        src={logo}
        width="100"
        height="50"
        className="d-inline-block align-top"
        alt="React Bootstrap logo"
      />
    </Navbar.Brand>
    </Col>
    <Col lg={5}>
    <Form >
  <Form.Group className=" d-flex justify-content-start mt-2">
    <Form.Control className="w-75" placeholder="Товар, услуга" />
    <Button  className="w-25"variant="outline-success">Find</Button>
  </Form.Group>
  </Form>
  </Col>
  <Col lg= {5}>
  <div className="mt-2 d-flex justify-content-end">
  <Button  variant="primary">Зарегистрироваться</Button>
  <Button className="ms-3" variant="primary">Войти</Button>
  </div>
  </Col>
  </Row>
      </Container>
    </Navbar>
  )
}

export default Header;

