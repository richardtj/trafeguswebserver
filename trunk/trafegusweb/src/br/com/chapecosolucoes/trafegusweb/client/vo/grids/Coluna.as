package br.com.chapecosolucoes.trafegusweb.client.vo.grids
{

    public class Coluna
    {

        public var posicao:int;

        public var tamanho:int;

        public var visivel:Boolean;

        public function Coluna(_posicao:int = 0, _tamanho:int = 0, _visivel:Boolean = false)
        {
            this.posicao = _posicao;
            this.tamanho = _tamanho;
			this.visivel = _visivel;
        }
    }
}