.class Lcom/kkinder/charmap/Charmap$1;
.super Ljava/lang/Object;
.source "Charmap.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kkinder/charmap/Charmap;->onOptionsItemSelected(Landroid/view/MenuItem;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kkinder/charmap/Charmap;


# direct methods
.method constructor <init>(Lcom/kkinder/charmap/Charmap;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kkinder/charmap/Charmap$1;->this$0:Lcom/kkinder/charmap/Charmap;

    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap$1;->this$0:Lcom/kkinder/charmap/Charmap;

    # getter for: Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;
    invoke-static {v0}, Lcom/kkinder/charmap/Charmap;->access$0(Lcom/kkinder/charmap/Charmap;)Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->hide()V

    .line 93
    return-void
.end method
