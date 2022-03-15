import React, { useState } from "react";
import {Navbar, Container, Row, Col, Form, Button } from "react-bootstrap";
import Modal from "./Modal/Modal";
import logo from '../img/logo.ico';
import useShowModal from "../hook/useShowModal";
import ModalButton from "./UI/Button/ModalButton";
import RegForm from "./Form/RegForm";

const Header = () =>{

 // const [modalReg, setModalReg] = useState(false);
 const regModal = useShowModal(false);

 const authModal = useShowModal(false);

 const [value, setValue] = useState()
  
    return(
      <div>
      <Navbar bg="dark" expand="dark" className="w-100">
      <Container className="d-flex justify-content-start w-100" fluid>
      <Row className="w-100">
      <Col lg={2}>
      <Navbar.Brand href="#home">
      <img
        src={logo}
        width="100"
        height="50"
        className="d-inline-block align-top ms-3"
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
  <ModalButton onClick={() => regModal.show(true)}>Зарегистрироваться</ModalButton>
  <ModalButton clazz="ms-3" onClick={() => authModal.show(true)}>Войти</ModalButton>

  </div>
  </Col>
  </Row>
      </Container>
    </Navbar>
    <Modal className="w-100" visible={regModal.isVisible} setVisible={() => regModal.show(false)}>
    <RegForm/>
      </Modal>
    <Modal visible={authModal.isVisible} setVisible={() => authModal.show(false)}>zgfjlsdxkgbs
    dgbsdgbjsdxzgbdx
    gbdxg</Modal>
    </div>
  )
}

export default Header;

