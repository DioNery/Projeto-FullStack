import React, { Component } from 'react'
import  UsuarioService from '../services/UsuarioService'
class ListUsuarioComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                usuarios: []
        }
        this.addUsuario = this.addUsuario.bind(this);
        this.editUsuario = this.editUsuario.bind(this);
        this.deleteUsuario = this.deleteUsuario.bind(this);
    }

    deleteUsuario(id){
         UsuarioService.deleteUsuario(id).then( res => {
            this.setState({usuarios: this.state.usuarios.filter(usuario => usuario.id !== id)});
        });
    }
    viewUsuario(id){
        this.props.history.push(`/view-usuario/${id}`);
    }
    editUsuario(id){
        this.props.history.push(`/add-usuario/${id}`);
    }

    componentDidMount(){
         UsuarioService.getUsuarios().then((res) => {
            this.setState({ usuarios: res.data});
        });
    }

    addUsuario(){
        this.props.history.push('/add-usuario/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Lista de Usuarios</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addUsuario}> Adicionar Usuario</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Usuario Nome</th>
                                    <th> Usuario Email</th>
                                    <th> Usuario Senha</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.usuarios.map(
                                        usuario => 
                                        <tr key = {usuario.id}>
                                             <td> { usuario.nome} </td>   
                                             <td> {usuario.email}</td>
                                             <td> {usuario.senha}</td>
                                             <td>
                                                 <button onClick={ () => this.editUsuario(usuario.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUsuario(usuario.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUsuario(usuario.id)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListUsuarioComponent