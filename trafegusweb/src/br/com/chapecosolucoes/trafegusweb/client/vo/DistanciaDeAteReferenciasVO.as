package br.com.chapecosolucoes.trafegusweb.client.vo
{
	public class DistanciaDeAteReferenciasVO extends DistanciaDeAteVO
	{
		public function DistanciaDeAteReferenciasVO(de:ReferenciaVO, ate:ReferenciaVO)
		{
			super(de, ate);
		}
		override public function getHtml():String
		{
			return "Distância de <br/><b>" + this.de.refeDescricao + "</b><br/>"+this.de.descricao+"<br/>Até <br/><b>"+this.ate.refeDescricao+"</b><br/>"+this.ate.descricao+"<br/><b>" + this.distanciaDeAte() + "</b>";
		}
	}
}