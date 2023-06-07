import React, { Component } from 'react'
import UsuarioService from '../services/UsuarioService';

class UpdateUsuarioComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nome: '',
            email: '',
            senha: ''
        }
        this.changeNomeHandler = this.changeNomeHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.updateUsuario = this.updateUsuario.bind(this);
    }

    componentDidMount(){
        UsuarioService.getUsuarioById(this.state.id).then( (res) =>{
            let usuario = res.data;
            this.setState({nome: usuario.nome,
                email: usuario.email,
                senha : usuario.senha
            });
        });
    }

    updateUsuario = (e) => {
        e.preventDefault();
        let usuario = {nome: this.state.nome, email: this.state.email, senha: this.state.senha};
        console.log('usuario => ' + JSON.stringify(usuario));
        console.log('id => ' + JSON.stringify(this.state.id));
        UsuarioService.updateUsuario(usuario, this.state.id).then( res => {
            this.props.history.push('/usuarios');
        });
    }
    
    changeNomeHandler= (event) => {
        this.setState({nome: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changeSenhaHandler= (event) => {
        this.setState({senha: event.target.value});
    }

    cancel(){
        this.props.history.push('/usuarios');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Usuario</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> First Name: </label>
                                            <input placeholder="First Name" name="nome" className="form-control" 
                                                value={this.state.nome} onChange={this.changeNomeHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Email: </label>
                                            <input placeholder="Email" name="email" className="form-control" 
                                               type="email" value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Senha: </label>
                                            <input placeholder="Senha" name="senha" className="form-control" 
                                              type="password"  value={this.state.senha} onChange={this.changeSenhaHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateUsuario}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateUsuarioComponent