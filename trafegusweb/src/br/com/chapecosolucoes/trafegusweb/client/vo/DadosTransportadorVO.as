package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class DadosTransportadorVO extends TransportadorVO
	{
		public function DadosTransportadorVO()
		{
			super();
		}
		public function setDadosTransportadorVO(obj:Object):void
		{
			this.codigoTransportador = obj.tran_pess_oras_codigo.toString();
			this.razaoSocial = obj.pjur_razao_social.toString();
			this.sexo = obj.pfis_sexo.toString();
			super.setTransportadorVO(obj);
		}
		public var codigoTransportador:String;
		public var razaoSocial:String;
		public var sexo:String;
	}
}