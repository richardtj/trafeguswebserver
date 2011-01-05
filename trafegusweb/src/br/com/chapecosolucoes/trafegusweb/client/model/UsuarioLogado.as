package br.com.chapecosolucoes.trafegusweb.client.model
{
    import br.com.chapecosolucoes.trafegusweb.client.utils.GUID;
    import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoTelasVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.grids.GridConfig;

    [Bindable]
    public class UsuarioLogado
    {
        private static var instance:UsuarioLogado;

        public var wsdl:String;

        private var _idSessao:String;

        public var gridConfig:GridConfig = new GridConfig();

        public var posicaoTelasVO:PosicaoTelasVO = new PosicaoTelasVO();

        public function UsuarioLogado(enforcer:SingletonEnforcer)
        {
            if (enforcer == null)
            {
                throw new Error("Só pode haver uma instância de [UsuarioLogado]");
            }

            _idSessao = GUID.create();

        }

        public static function getInstance():UsuarioLogado
        {
            if (instance == null)
                instance = new UsuarioLogado(new SingletonEnforcer());
            return instance;
        }

        public function get IdSessao():String
        {
            return _idSessao;
        }

        public function cleanUp():void
        {
            instance = null;
        }

    }
}

class SingletonEnforcer
{

}