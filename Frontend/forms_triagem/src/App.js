import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import ListUsuarioComponent from './components/LisUsuarioComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FoooterComponent';
import CreateUsuarioComponent from './components/CreateUsuarioComponent';
import UpdateUsuarioComponent from './components/UpdateUsuarioComponent';
import ViewUsuarioComponent from './components/ViewUsuarioComponent';

function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListUsuarioComponent}></Route>
                          <Route path = "/Usuarios" component = {ListUsuarioComponent}></Route>
                          <Route path = "/add-usuario/:id" component = {CreateUsuarioComponent}></Route>
                          <Route path = "/view-usuario/:id" component = {ViewUsuarioComponent}></Route>
                          {/* <Route path = "/update-usuario/:id" component = {UpdateUsuarioComponent}></Route> */}
                    </Switch>
                </div>
              <FooterComponent />
        </Router>
    </div>
    
  );
}

export default App;