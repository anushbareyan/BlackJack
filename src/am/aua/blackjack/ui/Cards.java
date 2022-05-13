package am.aua.blackjack.ui;
import am.aua.blackjack.core.Card;
import am.aua.blackjack.core.Dealer;

import javax.swing.*;
public class Cards extends JButton {
    public void setCard() {
        this.setIcon(null);
    }

    public void setCard(Card.Suit s, Card.Value v) {
        if (v == Card.Value.TWO) {
            if (s == Card.Suit.CLUB) {
                this.setIcon(new ImageIcon("\\CardDeck\\0.png"));
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon(new ImageIcon("\\CardDeck\\1.png"));
            } else if (s == Card.Suit.HEART) {
                this.setIcon(new ImageIcon("\\CardDeck\\2.png"));
            } else if (s == Card.Suit.SPADE) {
                this.setIcon(new ImageIcon("\\CardDeck\\3.png"));
            }
        } else if (v == Card.Value.THREE) {
            if (s == Card.Suit.CLUB) {
                this.setIcon(new ImageIcon("\\CardDeck\\4.png"));
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon(new ImageIcon("\\CardDeck\\5.png"));
            } else if (s == Card.Suit.HEART) {
                this.setIcon(new ImageIcon("\\CardDeck\\6.png"));
            } else if (s == Card.Suit.SPADE) {
                this.setIcon(new ImageIcon("\\CardDeck\\7.png"));
            }
        } else if (v == Card.Value.FOUR) {
            if (s == Card.Suit.CLUB) {
                this.setIcon(new ImageIcon("\\CardDeck\\8.png"));
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon(new ImageIcon("\\CardDeck\\9.png"));
            } else if (s == Card.Suit.HEART) {
                this.setIcon(new ImageIcon("\\CardDeck\\10.png"));
            } else if (s == Card.Suit.SPADE) {
                this.setIcon(new ImageIcon("\\CardDeck\\11.png"));
            }
        } else if (v == Card.Value.FIVE) {
            if (s == Card.Suit.CLUB) {
                this.setIcon(new ImageIcon("\\CardDeck\\12.png"));
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon(new ImageIcon("\\CardDeck\\13.png"));
            } else if (s == Card.Suit.HEART) {
                this.setIcon(new ImageIcon("\\CardDeck\\14.png"));
            } else if (s == Card.Suit.SPADE) {
                this.setIcon(new ImageIcon("\\CardDeck\\15.png"));
            }
        } else if (v == Card.Value.SIX) {
            if (s == Card.Suit.CLUB) {
                this.setIcon(new ImageIcon("\\CardDeck\\16.png"));
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon(new ImageIcon("\\CardDeck\\17.png"));
            } else if (s == Card.Suit.HEART) {
                this.setIcon(new ImageIcon("\\CardDeck\\18.png"));
            } else if (s == Card.Suit.SPADE) {
                this.setIcon(new ImageIcon("\\CardDeck\\19.png"));
            }
        } else if (v == Card.Value.SEVEN) {
            if (s == Card.Suit.CLUB) {
                this.setIcon(new ImageIcon("\\CardDeck\\20.png"));
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon(new ImageIcon("\\CardDeck\\21.png"));
            } else if (s == Card.Suit.HEART) {
                this.setIcon(new ImageIcon("\\CardDeck\\22.png"));
            } else if (s == Card.Suit.SPADE) {
                this.setIcon(new ImageIcon("\\CardDeck\\23.png"));
            }
        } else if (v == Card.Value.EIGHT) {
            if (s == Card.Suit.CLUB) {
                this.setIcon(new ImageIcon("\\CardDeck\\24.png"));
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon(new ImageIcon("\\CardDeck\\25.png"));
            } else if (s == Card.Suit.HEART) {
                this.setIcon(new ImageIcon("\\CardDeck\\26.png"));
            } else if (s == Card.Suit.SPADE) {
                this.setIcon(new ImageIcon("\\CardDeck\\27.png"));
            }
        } else if(v == Card.Value.NINE) {
            if (s == Card.Suit.CLUB) {
                this.setIcon( new ImageIcon( "\\CardDeck\\28.png" ) );
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon( new ImageIcon( "\\CardDeck\\29.png" ) );
            } else if (s == Card.Suit.HEART) {
                this.setIcon( new ImageIcon( "\\CardDeck\\30.png" ) );
            } else if (s == Card.Suit.SPADE) {
                this.setIcon( new ImageIcon( "\\CardDeck\\31.png" ) );
            }
        } else if(v == Card.Value.TEN) {
            if (s == Card.Suit.CLUB) {
                this.setIcon( new ImageIcon( "\\CardDeck\\32.png" ) );
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon( new ImageIcon( "\\CardDeck\\33.png" ) );
            } else if (s == Card.Suit.HEART) {
                this.setIcon( new ImageIcon( "\\CardDeck\\34.png" ) );
            } else if (s == Card.Suit.SPADE) {
                this.setIcon( new ImageIcon( "\\CardDeck\\35.png" ) );
            }
        } else if(v == Card.Value.ACE) {
            if (s == Card.Suit.CLUB) {
                this.setIcon( new ImageIcon( "\\CardDeck\\36.png" ) );
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon( new ImageIcon( "\\CardDeck\\37.png" ) );
            } else if (s == Card.Suit.HEART) {
                this.setIcon( new ImageIcon( "\\CardDeck\\38.png" ) );
            } else if (s == Card.Suit.SPADE) {
                this.setIcon( new ImageIcon( "\\CardDeck\\39.png" ) );
            }
        } else if(v == Card.Value.JACK) {
            if (s == Card.Suit.CLUB) {
                this.setIcon( new ImageIcon( "\\CardDeck\\40.png" ) );
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon( new ImageIcon( "\\CardDeck\\41.png" ) );
            } else if (s == Card.Suit.HEART) {
                this.setIcon( new ImageIcon( "\\CardDeck\\42.png" ) );
            } else if (s == Card.Suit.SPADE) {
                this.setIcon( new ImageIcon( "\\CardDeck\\43.png" ) );
            }
        } else if(v == Card.Value.KING) {
            if (s == Card.Suit.CLUB) {
                this.setIcon( new ImageIcon( "\\CardDeck\\44.png" ) );
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon( new ImageIcon( "\\CardDeck\\45.png" ) );
            } else if (s == Card.Suit.HEART) {
                this.setIcon( new ImageIcon( "\\CardDeck\\46.png" ) );
            } else if (s == Card.Suit.SPADE) {
                this.setIcon( new ImageIcon( "\\CardDeck\\47.png" ) );
            }
        } else if(v == Card.Value.QUEEN) {
            if (s == Card.Suit.CLUB) {
                this.setIcon( new ImageIcon( "\\CardDeck\\48.png" ) );
            } else if (s == Card.Suit.DIAMOND) {
                this.setIcon( new ImageIcon( "\\CardDeck\\49.png" ) );
            } else if (s == Card.Suit.HEART) {
                this.setIcon( new ImageIcon( "\\CardDeck\\50.png" ) );
            } else if (s == Card.Suit.SPADE) {
                this.setIcon( new ImageIcon( "\\CardDeck\\51.png" ) );
            }
        }
//        else if(s == ) {
//            this.setIcon( new ImageIcon( "\\CardDeck\\backBlack.png" ) );
//        }



    }
}