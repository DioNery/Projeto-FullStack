import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import Home from './routes/Home.jsx'
import Contato from './routes/Contato.jsx'
import App from './routes/App'
//importações para o router 
import { BrowserRouter, RouterProvider, createBrowserRouter } from 'react-router-dom'
import Cadastro from './routes/Cadastro.jsx'


const rotas = createBrowserRouter([

  {
    path : '/', 
    element: <App/>,
  }, 
      
  {
    path: '/triagem',
    element: <Home/>,
  },

  {
    path: '/medicos',
    element: <Contato/>,
  },
  {
    path: '/cadastro',
    element: <Cadastro/>,
  }

]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router = {rotas}/>
  </React.StrictMode>,
)
