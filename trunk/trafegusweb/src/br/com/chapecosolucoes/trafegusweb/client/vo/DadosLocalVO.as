package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class DadosLocalVO extends LocalVO
	{
		public function DadosLocalVO()
		{
			super();
		}
		public function setDadosLocalVO(obj:Object):void
		{
			this.raio = obj.refe_raio.toString();
			this.km = obj.refe_km.toString();
			this.bandeira = obj.refe_bandeira.toString();
			this.sistema = obj.refe_utilizado_sistema.toString();
			super.setLocalVO(obj);
		}
		public var raio:String;
		public var km:String;
		public var bandeira:String;
		public var sistema:String;
	}
}