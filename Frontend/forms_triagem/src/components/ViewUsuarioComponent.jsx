import React, { Component } from 'react'
import UsuarioService from '../services/UsuarioService'

class ViewUsuarioComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            usuario: {}
        }
    }

    componentDidMount(){
        UsuarioService.getUsuarioById(this.state.id).then( res => {
            this.setState({usuario: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> Ver Detalhes do Usuario</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Usuario nome: </label>
                            <div> { this.state.usuario.nome }</div>
                        </div>
                        <div className = "row">
                            <label> Usuario email: </label>
                            <div> { this.state.usuario.email }</div>
                        </div>
                        <div className = "row">
                            <label> Usuario senha: </label>
                            <div> { this.state.usuario.senha }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewUsuarioComponent