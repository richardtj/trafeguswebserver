package br.com.chapecosolucoes.trafegusweb.client.vo.grids
{
    import mx.collections.ArrayCollection;

    public class Grid
    {
        public var idGrid:String;

        private var colunas:ArrayCollection;

        public function Grid()
        {
            colunas = new ArrayCollection();
        }

        private function findColuna(nome:String):int
        {
            for (var i:int = 0; i < colunas.length; i++)
            {
                if (Coluna(colunas.getItemAt(i)).nome == nome)
                {
                    return i;
                }
            }
            return -1;
        }

        public function getColunaByName(nome:String):Coluna
        {
            var i:int = findColuna(nome);

            if (i >= 0)
            {
                return getColunaByIndex(i);
            }
            return null;
        }

        public function getColunaByIndex(idx:int):Coluna
        {
            if ((idx >= 0) && (idx < colunas.length))
            {
                return Coluna(colunas.getItemAt(idx));
            }
            return null;
        }

        public function size():int
        {
            return colunas.length;
        }

        public function addColuna(_nome:String, _posicao:int = 0, _tamanho:int = 0, _visivel:Boolean = false):void
        {
            var col:Coluna = null;
            var i:int = findColuna(_nome);

            if (i < 0)
            {
                col = new Coluna(_nome, _posicao, _tamanho, _visivel);
            }
            else
            {
                col = getColunaByIndex(i);
                col.nome = _nome;
                col.posicao = _posicao;
                col.tamanho = _tamanho;
                col.visivel = _visivel;

                removeColuna(_nome);
                colunas.addItemAt(col, i);
            }
        }

        public function removeColuna(nome:String):void
        {
            var i:int = findColuna(nome);

            if (i >= 0)
            {
                colunas.removeItemAt(i);
            }
        }

        public function toXML():String
        {
            var result:String = "";
            result += "   <grid>/n";
            result += "      <nome>" + this.idGrid + "</nome>/n";
            result += "      <colunas>/n";
            for (var i:int = 0; i < size(); i++)
            {
                result += getColunaByIndex(i).toXML();
            }
            result += "      </colunas>/n";
            result += "   </grid>/n";

            return result;
        }
    }
}