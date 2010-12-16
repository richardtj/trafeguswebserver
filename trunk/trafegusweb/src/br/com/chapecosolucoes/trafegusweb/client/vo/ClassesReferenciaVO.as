package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class ClassesReferenciaVO
	{
		public function ClassesReferenciaVO()
		{
		}
		public function setClassesReferenciaVO(obj:Object):void
		{
			this.codigo = obj.cref_codigo.toString();
			this.descricao = obj.cref_descricao.toString();
			this.classeSistema = obj.cref_classe_sistema.toString();
		}
		public var selected:Boolean;
		public var codigo:String;
		public var descricao:String;
		public var classeSistema:String;
	}
}