/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkiruokareseptigeneraattori.uis;
import jalkiruokareseptigeneraattori.blogic.Recipe;
import jalkiruokareseptigeneraattori.blogic.Recipebook;
/**
 *
 * @author niemi
 */
public interface RpInt {

    /**
     *
     * @return This will pick up random recipe and return 
     */
    Recipe getRandomRecipe();

    /**
     *
     * @return list of groups
     */
    String printGroups();
}
