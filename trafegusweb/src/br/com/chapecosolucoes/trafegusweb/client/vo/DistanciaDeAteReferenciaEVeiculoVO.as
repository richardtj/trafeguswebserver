package br.com.chapecosolucoes.trafegusweb.client.vo
{
	public class DistanciaDeAteReferenciaEVeiculoVO extends DistanciaDeAteVO
	{
		public function DistanciaDeAteReferenciaEVeiculoVO(de:PosicaoVeiculoVO, ate:ReferenciaVO)
		{
			super(de, ate);
		}
		override public function getHtml():String
		{
			return "Distância de <br/><b>" + this.de.vehiclePlate + "</b><br/>"+this.de.gpsDescSis+"<br/>"+this.de.dataEHora+"<br/>Até <br/><b>"+this.ate.refeDescricao+"</b><br/>"+this.ate.descricao+"<br/><b>" + this.distanciaDeAte() + "</b>";
		}
	}
}