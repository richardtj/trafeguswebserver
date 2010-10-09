package br.com.chapecosolucoes.trafegusweb.client.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	public final class MainModel
	{
		private static var instance:MainModel;
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.vo.DataPos")]
		public var dpPosicao:ArrayCollection;
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.vo.DataMsg")]
		public var dpMensagens:ArrayCollection;

		public var veiculoSelecionado:String;

		public function MainModel(enforcer:SingletonEnforcer)
		{
			if (enforcer == null)
			{
				throw new Error("Só pode haver uma instância de UserModel");
			}
		}

		public static function getInstance():MainModel
		{
			if (instance == null)
				instance = new MainModel(new SingletonEnforcer());
			return instance;
		}

	}
}

class SingletonEnforcer
{

}