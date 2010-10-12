/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.vo;

import java.io.Serializable;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;

/**
 *
 * @author estevan
 */
@SqlResultSetMapping(name = "selectVeiculos", entities = {
    @EntityResult(entityClass = SolicitaListaVeiculosVO.class, fields = {
        @FieldResult(name = "codigo", column = "ORAS_CODIGO"),
        @FieldResult(name = "placa", column = "VEIC_PLACA"),
        @FieldResult(name = "tipoDescricao", column = "TVEI_DESCRICAO")})})
public class SolicitaListaVeiculosVO implements Serializable {

    private Integer codigo;
    private String placa;
    private String tipoDescricao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
    }

    public SolicitaListaVeiculosVO() {
    }
}
