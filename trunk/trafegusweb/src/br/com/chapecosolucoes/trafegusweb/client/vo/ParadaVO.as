package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class ParadaVO
	{
		public function ParadaVO()
		{
		}
		public function setParadaVO(obj:Object):void
		{
			this.codigoTipoParada = obj.tpar_codigo.toString();
			this.descricaoTipoParada = obj.tpar_descricao.toString();
			this.codigoReferencia = obj.refe_codigo.toString();
			this.descricaoReferencia = obj.refe_descricao.toString();
		}
		public var codigoTipoParada:String;
		public var descricaoTipoParada:String;
		public var codigoReferencia:String;
		public var descricaoReferencia:String;
		
		//public var tipoParadaVO:TipoParadaVO;
		//public var localParadaVO:LocalVO;
	}
}