package lab.polymorphism;

/**
 * A text block right-justified in a given width.
 *
 * @author Jayson Kunkel
 */
public class RightJustified implements TextBlock{
   // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The text block.
   */
  TextBlock contents;

  /**
   * The desired width of the new block.
   */
  int maxWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing left and right side by side.
   */
  public RightJustified(TextBlock _contents, int _maxWidth) throws Exception
  {
    this.contents = _contents;

    if(_maxWidth < 0 ){
      throw new Exception("Invalid width " + _maxWidth);
    }
    else{
      this.maxWidth = _maxWidth;
    } // if width is invalid
  } // RightJustified (TextBlock, int)

/**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row (int i) throws Exception {
    
    int mw = this.maxWidth;
    int w = this.contents.width();
    int h = this.contents.height();

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    // determine padding
    // return the row
    if(w == mw){
      return this.contents.row(i);
    }
    // truncate the row
    else if(w > mw){
      return TBUtils.truncateRow(this.contents.row(i), w, mw);
    }
    // pad with spaces to the front
    else{
      String padFront = TBUtils.spaces(mw - w);
      return padFront + this.contents.row(i);
    }
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height(){
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width(){
    return this.maxWidth;
  } // width()

  /**
   * Access the contents of the block.
   */
  public TextBlock getContents(){
    return this.contents;
  } // getContents()
  
  /**
   * Determine if two TextBlocks are equal (built in the same way)
   */
  public boolean eqv(TextBlock other){
    boolean sameType = this instanceof RightJustified && other instanceof RightJustified;
    return sameType && this.contents.eqv(other.getContents());
  } // eqv (TextBlock)
  
} // class RightJustified
