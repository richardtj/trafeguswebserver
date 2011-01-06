package br.com.chapecosolucoes.trafegusweb.client.vo.grids
{
    import br.com.chapecosolucoes.trafegusweb.client.utils.XmlUtils;

    import mx.collections.ArrayCollection;

    public class GridConfig
    {
        private static var instance:GridConfig;

        private var grids:ArrayCollection

        public function GridConfig(enforcer:SingletonEnforcer)
        {
            if (enforcer == null)
            {
                throw new Error("Só pode haver uma instância de [GridConfig]");
            }
            grids = new ArrayCollection();
        }

        public static function getInstance():GridConfig
        {
            if (instance == null)
                instance = new GridConfig(new SingletonEnforcer());
            return instance;
        }


        public function addGrid(grid:Grid):void
        {
            var i:int = findGrid(grid.idGrid);
            if (i < 0)
            {
                grids.addItem(grid);
            }
        }

        private function findGrid(nome:String):int
        {
            for (var i:int = 0; i < grids.length; i++)
            {
                if (Grid(grids.getItemAt(i)).idGrid == nome)
                {
                    return i;
                }
            }
            return -1;
        }

        public function size():int
        {
            return grids.length;
        }

        public function getGridByIndex(idx:int):Grid
        {
            if ((idx >= 0) && (idx < grids.length))
            {
                return Grid(grids.getItemAt(idx));
            }
            return null;
        }

        public function getGridByName(nome:String):Grid
        {
            var i:int = findGrid(nome);

            if (i >= 0)
            {
                return getGridByIndex(i);
            }
            return null;
        }

        public function removeGridByName(nome:String):void
        {
            var i:int = findGrid(nome);

            if (i >= 0)
            {
                grids.removeItemAt(i);
            }
        }

        public function removeGrid(grid:Grid):void
        {
            removeGridByName(grid.idGrid);
        }
        public function toXML():String
        {
            var result:String = "";
            result += "<grids>/n";
            for (var i:int = 0; i < size(); i++)
            {
                result += getGridByIndex(i).toXML();
            }
            result += "</grids>/n";

            return result;
        }
    }
}

class SingletonEnforcer
{

}