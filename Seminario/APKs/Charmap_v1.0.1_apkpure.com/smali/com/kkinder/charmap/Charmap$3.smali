.class Lcom/kkinder/charmap/Charmap$3;
.super Ljava/lang/Object;
.source "Charmap.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kkinder/charmap/Charmap;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemSelectedListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kkinder/charmap/Charmap;


# direct methods
.method constructor <init>(Lcom/kkinder/charmap/Charmap;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    .line 157
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 11
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 161
    .local p1, "adapter":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    invoke-static {v0, p3}, Lcom/kkinder/charmap/Charmap;->access$1(Lcom/kkinder/charmap/Charmap;I)V

    .line 163
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    invoke-virtual {v0}, Lcom/kkinder/charmap/Charmap;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 164
    .local v1, "c":Landroid/content/Context;
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    const v2, 0x7f060005

    invoke-virtual {v0, v2}, Lcom/kkinder/charmap/Charmap;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/GridView;

    .line 165
    .local v7, "gridview":Landroid/widget/GridView;
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    const v2, 0x7f060007

    invoke-virtual {v0, v2}, Lcom/kkinder/charmap/Charmap;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    .line 166
    .local v4, "editor":Landroid/widget/EditText;
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    const v2, 0x7f060006

    invoke-virtual {v0, v2}, Lcom/kkinder/charmap/Charmap;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 168
    .local v3, "editArea":Landroid/widget/LinearLayout;
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 169
    .local v6, "charmap":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    iget-object v0, v0, Lcom/kkinder/charmap/Charmap;->charmaps:[[I

    aget-object v0, v0, p3

    const/4 v2, 0x0

    aget v9, v0, v2

    .line 170
    .local v9, "start":I
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    iget-object v0, v0, Lcom/kkinder/charmap/Charmap;->charmaps:[[I

    aget-object v0, v0, p3

    const/4 v2, 0x1

    aget v0, v0, v2

    add-int/lit8 v10, v0, 0x1

    .line 171
    .local v10, "stop":I
    move v8, v9

    .local v8, "i":I
    :goto_0
    if-lt v8, v10, :cond_0

    .line 174
    sub-int v0, v10, v9

    new-array v5, v0, [Ljava/lang/String;

    .line 175
    .local v5, "charmapChars":[Ljava/lang/String;
    invoke-interface {v6, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 176
    new-instance v0, Lcom/kkinder/charmap/ButtonMapAdapter;

    iget-object v2, p0, Lcom/kkinder/charmap/Charmap$3;->this$0:Lcom/kkinder/charmap/Charmap;

    invoke-direct/range {v0 .. v5}, Lcom/kkinder/charmap/ButtonMapAdapter;-><init>(Landroid/content/Context;Lcom/kkinder/charmap/Charmap;Landroid/view/View;Landroid/widget/EditText;[Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 177
    return-void

    .line 172
    .end local v5    # "charmapChars":[Ljava/lang/String;
    :cond_0
    new-instance v0, Ljava/lang/String;

    int-to-char v2, v8

    invoke-static {v2}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Character;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 171
    add-int/lit8 v8, v8, 0x1

    goto :goto_0
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 182
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method
