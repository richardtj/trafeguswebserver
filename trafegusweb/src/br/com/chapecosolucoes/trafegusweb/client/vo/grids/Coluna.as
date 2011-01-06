package br.com.chapecosolucoes.trafegusweb.client.vo.grids
{

    public class Coluna
    {
        public var nome:String;

        public var posicao:int;

        public var tamanho:int;

        public var visivel:Boolean;

        public function Coluna(_nome:String, _posicao:int = 0, _tamanho:int = 0, _visivel:Boolean = false)
        {
            this.nome = _nome;
            this.posicao = _posicao;
            this.tamanho = _tamanho;
            this.visivel = _visivel;
        }

        public function toXML():String
        {
            var result:String = "";
            result += "         <coluna>/n";
            result += "            <nome>" + this.nome + "</nome>/n";
            result += "            <tamanho>" + this.tamanho + "</tamanho>/n";
            result += "            <posicao>" + this.posicao + "</posicao>/n";
            result += "            <visivel>" + this.visivel + "</visivel>/n";
            result += "         </coluna>/n";
            return result;
        }
    }
}