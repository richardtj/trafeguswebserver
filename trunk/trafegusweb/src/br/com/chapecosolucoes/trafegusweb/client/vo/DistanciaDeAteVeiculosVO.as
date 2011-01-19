package br.com.chapecosolucoes.trafegusweb.client.vo
{
	public class DistanciaDeAteVeiculosVO extends DistanciaDeAteVO
	{
		public function DistanciaDeAteVeiculosVO(de:PosicaoVeiculoVO, ate:PosicaoVeiculoVO)
		{
			super(de, ate);
		}
		override public function getHtml():String
		{
			return "Distância de <br/><b>" + this.de.vehiclePlate + "</b><br/>"+this.de.gpsDescSis+"<br/>"+this.de.dataEHora+"<br/>Até <br/><b>"+this.ate.vehiclePlate+"</b><br/>"+this.ate.gpsDescSis+"<br/>" + this.ate.dataEHora + "<br/><b>" + this.distanciaDeAte() + "</b>";
		}
	}
}