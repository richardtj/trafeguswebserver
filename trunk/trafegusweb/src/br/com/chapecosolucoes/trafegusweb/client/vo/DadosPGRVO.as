package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class DadosPGRVO extends PGRVO
	{
		public function DadosPGRVO()
		{
			super();
		}
		public function setDadosPGRVO(obj:Object):void
		{
			this.piteCodigo = obj.pite_codigo.toString();
			this.piteDescricao = obj.pite_descricao.toString();
			super.setPGRVO(obj);
		}
		public var piteCodigo:String;
		public var piteDescricao:String;
	}
}