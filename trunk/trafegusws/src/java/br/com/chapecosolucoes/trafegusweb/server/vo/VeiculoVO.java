/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.vo;

import java.io.Serializable;
import javax.persistence.ColumnResult;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;


/**
 *
 * @author estevan
 */
@SqlResultSetMapping(name="VeiculoVO",
entities=@EntityResult(
          entityClass=VeiculoVO.class,
          fields=@FieldResult(name="placaVeiculo", column="circuito")),
    columns=@ColumnResult(name="resCount")
)
public class VeiculoVO implements Serializable{
    private String placaVeiculo;
    private String tipoVeiculoDescricao;

    /**
     * @return the placaVeiculo
     */
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * @param placaVeiculo the placaVeiculo to set
     */
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    /**
     * @return the tipoVeiculoDescricao
     */
    public String getTipoVeiculoDescricao() {
        return tipoVeiculoDescricao;
    }

    /**
     * @param tipoVeiculoDescricao the tipoVeiculoDescricao to set
     */
    public void setTipoVeiculoDescricao(String tipoVeiculoDescricao) {
        this.tipoVeiculoDescricao = tipoVeiculoDescricao;
    }
}
