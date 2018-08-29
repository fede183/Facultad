.class public Lcom/kkinder/charmap/Charmap;
.super Landroid/app/Activity;
.source "Charmap.java"


# instance fields
.field private batchMode:Ljava/lang/Boolean;

.field final charmapNames:[Ljava/lang/String;

.field final charmaps:[[I

.field private dialog:Landroid/app/Dialog;

.field private page:I


# direct methods
.method public constructor <init>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v3, 0x2

    .line 32
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 187
    const/16 v0, 0xd1

    new-array v0, v0, [[I

    .line 188
    new-array v1, v3, [I

    fill-array-data v1, :array_0

    aput-object v1, v0, v4

    .line 189
    new-array v1, v3, [I

    fill-array-data v1, :array_1

    aput-object v1, v0, v5

    .line 190
    new-array v1, v3, [I

    fill-array-data v1, :array_2

    aput-object v1, v0, v3

    .line 191
    new-array v1, v3, [I

    fill-array-data v1, :array_3

    aput-object v1, v0, v6

    .line 192
    new-array v1, v3, [I

    fill-array-data v1, :array_4

    aput-object v1, v0, v7

    const/4 v1, 0x5

    .line 193
    new-array v2, v3, [I

    fill-array-data v2, :array_5

    aput-object v2, v0, v1

    const/4 v1, 0x6

    .line 194
    new-array v2, v3, [I

    fill-array-data v2, :array_6

    aput-object v2, v0, v1

    const/4 v1, 0x7

    .line 195
    new-array v2, v3, [I

    fill-array-data v2, :array_7

    aput-object v2, v0, v1

    const/16 v1, 0x8

    .line 196
    new-array v2, v3, [I

    fill-array-data v2, :array_8

    aput-object v2, v0, v1

    const/16 v1, 0x9

    .line 197
    new-array v2, v3, [I

    fill-array-data v2, :array_9

    aput-object v2, v0, v1

    const/16 v1, 0xa

    .line 198
    new-array v2, v3, [I

    fill-array-data v2, :array_a

    aput-object v2, v0, v1

    const/16 v1, 0xb

    .line 199
    new-array v2, v3, [I

    fill-array-data v2, :array_b

    aput-object v2, v0, v1

    const/16 v1, 0xc

    .line 200
    new-array v2, v3, [I

    fill-array-data v2, :array_c

    aput-object v2, v0, v1

    const/16 v1, 0xd

    .line 201
    new-array v2, v3, [I

    fill-array-data v2, :array_d

    aput-object v2, v0, v1

    const/16 v1, 0xe

    .line 202
    new-array v2, v3, [I

    fill-array-data v2, :array_e

    aput-object v2, v0, v1

    const/16 v1, 0xf

    .line 203
    new-array v2, v3, [I

    fill-array-data v2, :array_f

    aput-object v2, v0, v1

    const/16 v1, 0x10

    .line 204
    new-array v2, v3, [I

    fill-array-data v2, :array_10

    aput-object v2, v0, v1

    const/16 v1, 0x11

    .line 205
    new-array v2, v3, [I

    fill-array-data v2, :array_11

    aput-object v2, v0, v1

    const/16 v1, 0x12

    .line 206
    new-array v2, v3, [I

    fill-array-data v2, :array_12

    aput-object v2, v0, v1

    const/16 v1, 0x13

    .line 207
    new-array v2, v3, [I

    fill-array-data v2, :array_13

    aput-object v2, v0, v1

    const/16 v1, 0x14

    .line 208
    new-array v2, v3, [I

    fill-array-data v2, :array_14

    aput-object v2, v0, v1

    const/16 v1, 0x15

    .line 209
    new-array v2, v3, [I

    fill-array-data v2, :array_15

    aput-object v2, v0, v1

    const/16 v1, 0x16

    .line 210
    new-array v2, v3, [I

    fill-array-data v2, :array_16

    aput-object v2, v0, v1

    const/16 v1, 0x17

    .line 211
    new-array v2, v3, [I

    fill-array-data v2, :array_17

    aput-object v2, v0, v1

    const/16 v1, 0x18

    .line 212
    new-array v2, v3, [I

    fill-array-data v2, :array_18

    aput-object v2, v0, v1

    const/16 v1, 0x19

    .line 213
    new-array v2, v3, [I

    fill-array-data v2, :array_19

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    .line 214
    new-array v2, v3, [I

    fill-array-data v2, :array_1a

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    .line 215
    new-array v2, v3, [I

    fill-array-data v2, :array_1b

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    .line 216
    new-array v2, v3, [I

    fill-array-data v2, :array_1c

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    .line 217
    new-array v2, v3, [I

    fill-array-data v2, :array_1d

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    .line 218
    new-array v2, v3, [I

    fill-array-data v2, :array_1e

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    .line 219
    new-array v2, v3, [I

    fill-array-data v2, :array_1f

    aput-object v2, v0, v1

    const/16 v1, 0x20

    .line 220
    new-array v2, v3, [I

    fill-array-data v2, :array_20

    aput-object v2, v0, v1

    const/16 v1, 0x21

    .line 221
    new-array v2, v3, [I

    fill-array-data v2, :array_21

    aput-object v2, v0, v1

    const/16 v1, 0x22

    .line 222
    new-array v2, v3, [I

    fill-array-data v2, :array_22

    aput-object v2, v0, v1

    const/16 v1, 0x23

    .line 223
    new-array v2, v3, [I

    fill-array-data v2, :array_23

    aput-object v2, v0, v1

    const/16 v1, 0x24

    .line 224
    new-array v2, v3, [I

    fill-array-data v2, :array_24

    aput-object v2, v0, v1

    const/16 v1, 0x25

    .line 225
    new-array v2, v3, [I

    fill-array-data v2, :array_25

    aput-object v2, v0, v1

    const/16 v1, 0x26

    .line 226
    new-array v2, v3, [I

    fill-array-data v2, :array_26

    aput-object v2, v0, v1

    const/16 v1, 0x27

    .line 227
    new-array v2, v3, [I

    fill-array-data v2, :array_27

    aput-object v2, v0, v1

    const/16 v1, 0x28

    .line 228
    new-array v2, v3, [I

    fill-array-data v2, :array_28

    aput-object v2, v0, v1

    const/16 v1, 0x29

    .line 229
    new-array v2, v3, [I

    fill-array-data v2, :array_29

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    .line 230
    new-array v2, v3, [I

    fill-array-data v2, :array_2a

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    .line 231
    new-array v2, v3, [I

    fill-array-data v2, :array_2b

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    .line 232
    new-array v2, v3, [I

    fill-array-data v2, :array_2c

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    .line 233
    new-array v2, v3, [I

    fill-array-data v2, :array_2d

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    .line 234
    new-array v2, v3, [I

    fill-array-data v2, :array_2e

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    .line 235
    new-array v2, v3, [I

    fill-array-data v2, :array_2f

    aput-object v2, v0, v1

    const/16 v1, 0x30

    .line 236
    new-array v2, v3, [I

    fill-array-data v2, :array_30

    aput-object v2, v0, v1

    const/16 v1, 0x31

    .line 237
    new-array v2, v3, [I

    fill-array-data v2, :array_31

    aput-object v2, v0, v1

    const/16 v1, 0x32

    .line 238
    new-array v2, v3, [I

    fill-array-data v2, :array_32

    aput-object v2, v0, v1

    const/16 v1, 0x33

    .line 239
    new-array v2, v3, [I

    fill-array-data v2, :array_33

    aput-object v2, v0, v1

    const/16 v1, 0x34

    .line 240
    new-array v2, v3, [I

    fill-array-data v2, :array_34

    aput-object v2, v0, v1

    const/16 v1, 0x35

    .line 241
    new-array v2, v3, [I

    fill-array-data v2, :array_35

    aput-object v2, v0, v1

    const/16 v1, 0x36

    .line 242
    new-array v2, v3, [I

    fill-array-data v2, :array_36

    aput-object v2, v0, v1

    const/16 v1, 0x37

    .line 243
    new-array v2, v3, [I

    fill-array-data v2, :array_37

    aput-object v2, v0, v1

    const/16 v1, 0x38

    .line 244
    new-array v2, v3, [I

    fill-array-data v2, :array_38

    aput-object v2, v0, v1

    const/16 v1, 0x39

    .line 245
    new-array v2, v3, [I

    fill-array-data v2, :array_39

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    .line 246
    new-array v2, v3, [I

    fill-array-data v2, :array_3a

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    .line 247
    new-array v2, v3, [I

    fill-array-data v2, :array_3b

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    .line 248
    new-array v2, v3, [I

    fill-array-data v2, :array_3c

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    .line 249
    new-array v2, v3, [I

    fill-array-data v2, :array_3d

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    .line 250
    new-array v2, v3, [I

    fill-array-data v2, :array_3e

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    .line 251
    new-array v2, v3, [I

    fill-array-data v2, :array_3f

    aput-object v2, v0, v1

    const/16 v1, 0x40

    .line 252
    new-array v2, v3, [I

    fill-array-data v2, :array_40

    aput-object v2, v0, v1

    const/16 v1, 0x41

    .line 253
    new-array v2, v3, [I

    fill-array-data v2, :array_41

    aput-object v2, v0, v1

    const/16 v1, 0x42

    .line 254
    new-array v2, v3, [I

    fill-array-data v2, :array_42

    aput-object v2, v0, v1

    const/16 v1, 0x43

    .line 255
    new-array v2, v3, [I

    fill-array-data v2, :array_43

    aput-object v2, v0, v1

    const/16 v1, 0x44

    .line 256
    new-array v2, v3, [I

    fill-array-data v2, :array_44

    aput-object v2, v0, v1

    const/16 v1, 0x45

    .line 257
    new-array v2, v3, [I

    fill-array-data v2, :array_45

    aput-object v2, v0, v1

    const/16 v1, 0x46

    .line 258
    new-array v2, v3, [I

    fill-array-data v2, :array_46

    aput-object v2, v0, v1

    const/16 v1, 0x47

    .line 259
    new-array v2, v3, [I

    fill-array-data v2, :array_47

    aput-object v2, v0, v1

    const/16 v1, 0x48

    .line 260
    new-array v2, v3, [I

    fill-array-data v2, :array_48

    aput-object v2, v0, v1

    const/16 v1, 0x49

    .line 261
    new-array v2, v3, [I

    fill-array-data v2, :array_49

    aput-object v2, v0, v1

    const/16 v1, 0x4a

    .line 262
    new-array v2, v3, [I

    fill-array-data v2, :array_4a

    aput-object v2, v0, v1

    const/16 v1, 0x4b

    .line 263
    new-array v2, v3, [I

    fill-array-data v2, :array_4b

    aput-object v2, v0, v1

    const/16 v1, 0x4c

    .line 264
    new-array v2, v3, [I

    fill-array-data v2, :array_4c

    aput-object v2, v0, v1

    const/16 v1, 0x4d

    .line 265
    new-array v2, v3, [I

    fill-array-data v2, :array_4d

    aput-object v2, v0, v1

    const/16 v1, 0x4e

    .line 266
    new-array v2, v3, [I

    fill-array-data v2, :array_4e

    aput-object v2, v0, v1

    const/16 v1, 0x4f

    .line 267
    new-array v2, v3, [I

    fill-array-data v2, :array_4f

    aput-object v2, v0, v1

    const/16 v1, 0x50

    .line 268
    new-array v2, v3, [I

    fill-array-data v2, :array_50

    aput-object v2, v0, v1

    const/16 v1, 0x51

    .line 269
    new-array v2, v3, [I

    fill-array-data v2, :array_51

    aput-object v2, v0, v1

    const/16 v1, 0x52

    .line 270
    new-array v2, v3, [I

    fill-array-data v2, :array_52

    aput-object v2, v0, v1

    const/16 v1, 0x53

    .line 271
    new-array v2, v3, [I

    fill-array-data v2, :array_53

    aput-object v2, v0, v1

    const/16 v1, 0x54

    .line 272
    new-array v2, v3, [I

    fill-array-data v2, :array_54

    aput-object v2, v0, v1

    const/16 v1, 0x55

    .line 273
    new-array v2, v3, [I

    fill-array-data v2, :array_55

    aput-object v2, v0, v1

    const/16 v1, 0x56

    .line 274
    new-array v2, v3, [I

    fill-array-data v2, :array_56

    aput-object v2, v0, v1

    const/16 v1, 0x57

    .line 275
    new-array v2, v3, [I

    fill-array-data v2, :array_57

    aput-object v2, v0, v1

    const/16 v1, 0x58

    .line 276
    new-array v2, v3, [I

    fill-array-data v2, :array_58

    aput-object v2, v0, v1

    const/16 v1, 0x59

    .line 277
    new-array v2, v3, [I

    fill-array-data v2, :array_59

    aput-object v2, v0, v1

    const/16 v1, 0x5a

    .line 278
    new-array v2, v3, [I

    fill-array-data v2, :array_5a

    aput-object v2, v0, v1

    const/16 v1, 0x5b

    .line 279
    new-array v2, v3, [I

    fill-array-data v2, :array_5b

    aput-object v2, v0, v1

    const/16 v1, 0x5c

    .line 280
    new-array v2, v3, [I

    fill-array-data v2, :array_5c

    aput-object v2, v0, v1

    const/16 v1, 0x5d

    .line 281
    new-array v2, v3, [I

    fill-array-data v2, :array_5d

    aput-object v2, v0, v1

    const/16 v1, 0x5e

    .line 282
    new-array v2, v3, [I

    fill-array-data v2, :array_5e

    aput-object v2, v0, v1

    const/16 v1, 0x5f

    .line 283
    new-array v2, v3, [I

    fill-array-data v2, :array_5f

    aput-object v2, v0, v1

    const/16 v1, 0x60

    .line 284
    new-array v2, v3, [I

    fill-array-data v2, :array_60

    aput-object v2, v0, v1

    const/16 v1, 0x61

    .line 285
    new-array v2, v3, [I

    fill-array-data v2, :array_61

    aput-object v2, v0, v1

    const/16 v1, 0x62

    .line 286
    new-array v2, v3, [I

    fill-array-data v2, :array_62

    aput-object v2, v0, v1

    const/16 v1, 0x63

    .line 287
    new-array v2, v3, [I

    fill-array-data v2, :array_63

    aput-object v2, v0, v1

    const/16 v1, 0x64

    .line 288
    new-array v2, v3, [I

    fill-array-data v2, :array_64

    aput-object v2, v0, v1

    const/16 v1, 0x65

    .line 289
    new-array v2, v3, [I

    fill-array-data v2, :array_65

    aput-object v2, v0, v1

    const/16 v1, 0x66

    .line 290
    new-array v2, v3, [I

    fill-array-data v2, :array_66

    aput-object v2, v0, v1

    const/16 v1, 0x67

    .line 291
    new-array v2, v3, [I

    fill-array-data v2, :array_67

    aput-object v2, v0, v1

    const/16 v1, 0x68

    .line 292
    new-array v2, v3, [I

    fill-array-data v2, :array_68

    aput-object v2, v0, v1

    const/16 v1, 0x69

    .line 293
    new-array v2, v3, [I

    fill-array-data v2, :array_69

    aput-object v2, v0, v1

    const/16 v1, 0x6a

    .line 294
    new-array v2, v3, [I

    fill-array-data v2, :array_6a

    aput-object v2, v0, v1

    const/16 v1, 0x6b

    .line 295
    new-array v2, v3, [I

    fill-array-data v2, :array_6b

    aput-object v2, v0, v1

    const/16 v1, 0x6c

    .line 296
    new-array v2, v3, [I

    fill-array-data v2, :array_6c

    aput-object v2, v0, v1

    const/16 v1, 0x6d

    .line 297
    new-array v2, v3, [I

    fill-array-data v2, :array_6d

    aput-object v2, v0, v1

    const/16 v1, 0x6e

    .line 298
    new-array v2, v3, [I

    fill-array-data v2, :array_6e

    aput-object v2, v0, v1

    const/16 v1, 0x6f

    .line 299
    new-array v2, v3, [I

    fill-array-data v2, :array_6f

    aput-object v2, v0, v1

    const/16 v1, 0x70

    .line 300
    new-array v2, v3, [I

    fill-array-data v2, :array_70

    aput-object v2, v0, v1

    const/16 v1, 0x71

    .line 301
    new-array v2, v3, [I

    fill-array-data v2, :array_71

    aput-object v2, v0, v1

    const/16 v1, 0x72

    .line 302
    new-array v2, v3, [I

    fill-array-data v2, :array_72

    aput-object v2, v0, v1

    const/16 v1, 0x73

    .line 303
    new-array v2, v3, [I

    fill-array-data v2, :array_73

    aput-object v2, v0, v1

    const/16 v1, 0x74

    .line 304
    new-array v2, v3, [I

    fill-array-data v2, :array_74

    aput-object v2, v0, v1

    const/16 v1, 0x75

    .line 305
    new-array v2, v3, [I

    fill-array-data v2, :array_75

    aput-object v2, v0, v1

    const/16 v1, 0x76

    .line 306
    new-array v2, v3, [I

    fill-array-data v2, :array_76

    aput-object v2, v0, v1

    const/16 v1, 0x77

    .line 307
    new-array v2, v3, [I

    fill-array-data v2, :array_77

    aput-object v2, v0, v1

    const/16 v1, 0x78

    .line 308
    new-array v2, v3, [I

    fill-array-data v2, :array_78

    aput-object v2, v0, v1

    const/16 v1, 0x79

    .line 309
    new-array v2, v3, [I

    fill-array-data v2, :array_79

    aput-object v2, v0, v1

    const/16 v1, 0x7a

    .line 310
    new-array v2, v3, [I

    fill-array-data v2, :array_7a

    aput-object v2, v0, v1

    const/16 v1, 0x7b

    .line 311
    new-array v2, v3, [I

    fill-array-data v2, :array_7b

    aput-object v2, v0, v1

    const/16 v1, 0x7c

    .line 312
    new-array v2, v3, [I

    fill-array-data v2, :array_7c

    aput-object v2, v0, v1

    const/16 v1, 0x7d

    .line 313
    new-array v2, v3, [I

    fill-array-data v2, :array_7d

    aput-object v2, v0, v1

    const/16 v1, 0x7e

    .line 314
    new-array v2, v3, [I

    fill-array-data v2, :array_7e

    aput-object v2, v0, v1

    const/16 v1, 0x7f

    .line 315
    new-array v2, v3, [I

    fill-array-data v2, :array_7f

    aput-object v2, v0, v1

    const/16 v1, 0x80

    .line 316
    new-array v2, v3, [I

    fill-array-data v2, :array_80

    aput-object v2, v0, v1

    const/16 v1, 0x81

    .line 317
    new-array v2, v3, [I

    fill-array-data v2, :array_81

    aput-object v2, v0, v1

    const/16 v1, 0x82

    .line 318
    new-array v2, v3, [I

    fill-array-data v2, :array_82

    aput-object v2, v0, v1

    const/16 v1, 0x83

    .line 319
    new-array v2, v3, [I

    fill-array-data v2, :array_83

    aput-object v2, v0, v1

    const/16 v1, 0x84

    .line 320
    new-array v2, v3, [I

    fill-array-data v2, :array_84

    aput-object v2, v0, v1

    const/16 v1, 0x85

    .line 321
    new-array v2, v3, [I

    fill-array-data v2, :array_85

    aput-object v2, v0, v1

    const/16 v1, 0x86

    .line 322
    new-array v2, v3, [I

    fill-array-data v2, :array_86

    aput-object v2, v0, v1

    const/16 v1, 0x87

    .line 323
    new-array v2, v3, [I

    fill-array-data v2, :array_87

    aput-object v2, v0, v1

    const/16 v1, 0x88

    .line 324
    new-array v2, v3, [I

    fill-array-data v2, :array_88

    aput-object v2, v0, v1

    const/16 v1, 0x89

    .line 325
    new-array v2, v3, [I

    fill-array-data v2, :array_89

    aput-object v2, v0, v1

    const/16 v1, 0x8a

    .line 326
    new-array v2, v3, [I

    fill-array-data v2, :array_8a

    aput-object v2, v0, v1

    const/16 v1, 0x8b

    .line 327
    new-array v2, v3, [I

    fill-array-data v2, :array_8b

    aput-object v2, v0, v1

    const/16 v1, 0x8c

    .line 328
    new-array v2, v3, [I

    fill-array-data v2, :array_8c

    aput-object v2, v0, v1

    const/16 v1, 0x8d

    .line 329
    new-array v2, v3, [I

    fill-array-data v2, :array_8d

    aput-object v2, v0, v1

    const/16 v1, 0x8e

    .line 330
    new-array v2, v3, [I

    fill-array-data v2, :array_8e

    aput-object v2, v0, v1

    const/16 v1, 0x8f

    .line 331
    new-array v2, v3, [I

    fill-array-data v2, :array_8f

    aput-object v2, v0, v1

    const/16 v1, 0x90

    .line 332
    new-array v2, v3, [I

    fill-array-data v2, :array_90

    aput-object v2, v0, v1

    const/16 v1, 0x91

    .line 333
    new-array v2, v3, [I

    fill-array-data v2, :array_91

    aput-object v2, v0, v1

    const/16 v1, 0x92

    .line 334
    new-array v2, v3, [I

    fill-array-data v2, :array_92

    aput-object v2, v0, v1

    const/16 v1, 0x93

    .line 335
    new-array v2, v3, [I

    fill-array-data v2, :array_93

    aput-object v2, v0, v1

    const/16 v1, 0x94

    .line 336
    new-array v2, v3, [I

    fill-array-data v2, :array_94

    aput-object v2, v0, v1

    const/16 v1, 0x95

    .line 337
    new-array v2, v3, [I

    fill-array-data v2, :array_95

    aput-object v2, v0, v1

    const/16 v1, 0x96

    .line 338
    new-array v2, v3, [I

    fill-array-data v2, :array_96

    aput-object v2, v0, v1

    const/16 v1, 0x97

    .line 339
    new-array v2, v3, [I

    fill-array-data v2, :array_97

    aput-object v2, v0, v1

    const/16 v1, 0x98

    .line 340
    new-array v2, v3, [I

    fill-array-data v2, :array_98

    aput-object v2, v0, v1

    const/16 v1, 0x99

    .line 341
    new-array v2, v3, [I

    fill-array-data v2, :array_99

    aput-object v2, v0, v1

    const/16 v1, 0x9a

    .line 342
    new-array v2, v3, [I

    fill-array-data v2, :array_9a

    aput-object v2, v0, v1

    const/16 v1, 0x9b

    .line 343
    new-array v2, v3, [I

    fill-array-data v2, :array_9b

    aput-object v2, v0, v1

    const/16 v1, 0x9c

    .line 344
    new-array v2, v3, [I

    fill-array-data v2, :array_9c

    aput-object v2, v0, v1

    const/16 v1, 0x9d

    .line 345
    new-array v2, v3, [I

    fill-array-data v2, :array_9d

    aput-object v2, v0, v1

    const/16 v1, 0x9e

    .line 346
    new-array v2, v3, [I

    fill-array-data v2, :array_9e

    aput-object v2, v0, v1

    const/16 v1, 0x9f

    .line 347
    new-array v2, v3, [I

    fill-array-data v2, :array_9f

    aput-object v2, v0, v1

    const/16 v1, 0xa0

    .line 348
    new-array v2, v3, [I

    fill-array-data v2, :array_a0

    aput-object v2, v0, v1

    const/16 v1, 0xa1

    .line 349
    new-array v2, v3, [I

    fill-array-data v2, :array_a1

    aput-object v2, v0, v1

    const/16 v1, 0xa2

    .line 350
    new-array v2, v3, [I

    fill-array-data v2, :array_a2

    aput-object v2, v0, v1

    const/16 v1, 0xa3

    .line 351
    new-array v2, v3, [I

    fill-array-data v2, :array_a3

    aput-object v2, v0, v1

    const/16 v1, 0xa4

    .line 352
    new-array v2, v3, [I

    fill-array-data v2, :array_a4

    aput-object v2, v0, v1

    const/16 v1, 0xa5

    .line 353
    new-array v2, v3, [I

    fill-array-data v2, :array_a5

    aput-object v2, v0, v1

    const/16 v1, 0xa6

    .line 354
    new-array v2, v3, [I

    fill-array-data v2, :array_a6

    aput-object v2, v0, v1

    const/16 v1, 0xa7

    .line 355
    new-array v2, v3, [I

    fill-array-data v2, :array_a7

    aput-object v2, v0, v1

    const/16 v1, 0xa8

    .line 356
    new-array v2, v3, [I

    fill-array-data v2, :array_a8

    aput-object v2, v0, v1

    const/16 v1, 0xa9

    .line 357
    new-array v2, v3, [I

    fill-array-data v2, :array_a9

    aput-object v2, v0, v1

    const/16 v1, 0xaa

    .line 358
    new-array v2, v3, [I

    fill-array-data v2, :array_aa

    aput-object v2, v0, v1

    const/16 v1, 0xab

    .line 359
    new-array v2, v3, [I

    fill-array-data v2, :array_ab

    aput-object v2, v0, v1

    const/16 v1, 0xac

    .line 360
    new-array v2, v3, [I

    fill-array-data v2, :array_ac

    aput-object v2, v0, v1

    const/16 v1, 0xad

    .line 361
    new-array v2, v3, [I

    fill-array-data v2, :array_ad

    aput-object v2, v0, v1

    const/16 v1, 0xae

    .line 362
    new-array v2, v3, [I

    fill-array-data v2, :array_ae

    aput-object v2, v0, v1

    const/16 v1, 0xaf

    .line 363
    new-array v2, v3, [I

    fill-array-data v2, :array_af

    aput-object v2, v0, v1

    const/16 v1, 0xb0

    .line 364
    new-array v2, v3, [I

    fill-array-data v2, :array_b0

    aput-object v2, v0, v1

    const/16 v1, 0xb1

    .line 365
    new-array v2, v3, [I

    fill-array-data v2, :array_b1

    aput-object v2, v0, v1

    const/16 v1, 0xb2

    .line 366
    new-array v2, v3, [I

    fill-array-data v2, :array_b2

    aput-object v2, v0, v1

    const/16 v1, 0xb3

    .line 367
    new-array v2, v3, [I

    fill-array-data v2, :array_b3

    aput-object v2, v0, v1

    const/16 v1, 0xb4

    .line 368
    new-array v2, v3, [I

    fill-array-data v2, :array_b4

    aput-object v2, v0, v1

    const/16 v1, 0xb5

    .line 369
    new-array v2, v3, [I

    fill-array-data v2, :array_b5

    aput-object v2, v0, v1

    const/16 v1, 0xb6

    .line 370
    new-array v2, v3, [I

    fill-array-data v2, :array_b6

    aput-object v2, v0, v1

    const/16 v1, 0xb7

    .line 371
    new-array v2, v3, [I

    fill-array-data v2, :array_b7

    aput-object v2, v0, v1

    const/16 v1, 0xb8

    .line 372
    new-array v2, v3, [I

    fill-array-data v2, :array_b8

    aput-object v2, v0, v1

    const/16 v1, 0xb9

    .line 373
    new-array v2, v3, [I

    fill-array-data v2, :array_b9

    aput-object v2, v0, v1

    const/16 v1, 0xba

    .line 374
    new-array v2, v3, [I

    fill-array-data v2, :array_ba

    aput-object v2, v0, v1

    const/16 v1, 0xbb

    .line 375
    new-array v2, v3, [I

    fill-array-data v2, :array_bb

    aput-object v2, v0, v1

    const/16 v1, 0xbc

    .line 376
    new-array v2, v3, [I

    fill-array-data v2, :array_bc

    aput-object v2, v0, v1

    const/16 v1, 0xbd

    .line 377
    new-array v2, v3, [I

    fill-array-data v2, :array_bd

    aput-object v2, v0, v1

    const/16 v1, 0xbe

    .line 378
    new-array v2, v3, [I

    fill-array-data v2, :array_be

    aput-object v2, v0, v1

    const/16 v1, 0xbf

    .line 379
    new-array v2, v3, [I

    fill-array-data v2, :array_bf

    aput-object v2, v0, v1

    const/16 v1, 0xc0

    .line 380
    new-array v2, v3, [I

    fill-array-data v2, :array_c0

    aput-object v2, v0, v1

    const/16 v1, 0xc1

    .line 381
    new-array v2, v3, [I

    fill-array-data v2, :array_c1

    aput-object v2, v0, v1

    const/16 v1, 0xc2

    .line 382
    new-array v2, v3, [I

    fill-array-data v2, :array_c2

    aput-object v2, v0, v1

    const/16 v1, 0xc3

    .line 383
    new-array v2, v3, [I

    fill-array-data v2, :array_c3

    aput-object v2, v0, v1

    const/16 v1, 0xc4

    .line 384
    new-array v2, v3, [I

    fill-array-data v2, :array_c4

    aput-object v2, v0, v1

    const/16 v1, 0xc5

    .line 385
    new-array v2, v3, [I

    fill-array-data v2, :array_c5

    aput-object v2, v0, v1

    const/16 v1, 0xc6

    .line 386
    new-array v2, v3, [I

    fill-array-data v2, :array_c6

    aput-object v2, v0, v1

    const/16 v1, 0xc7

    .line 387
    new-array v2, v3, [I

    fill-array-data v2, :array_c7

    aput-object v2, v0, v1

    const/16 v1, 0xc8

    .line 388
    new-array v2, v3, [I

    fill-array-data v2, :array_c8

    aput-object v2, v0, v1

    const/16 v1, 0xc9

    .line 389
    new-array v2, v3, [I

    fill-array-data v2, :array_c9

    aput-object v2, v0, v1

    const/16 v1, 0xca

    .line 390
    new-array v2, v3, [I

    fill-array-data v2, :array_ca

    aput-object v2, v0, v1

    const/16 v1, 0xcb

    .line 391
    new-array v2, v3, [I

    fill-array-data v2, :array_cb

    aput-object v2, v0, v1

    const/16 v1, 0xcc

    .line 392
    new-array v2, v3, [I

    fill-array-data v2, :array_cc

    aput-object v2, v0, v1

    const/16 v1, 0xcd

    .line 393
    new-array v2, v3, [I

    fill-array-data v2, :array_cd

    aput-object v2, v0, v1

    const/16 v1, 0xce

    .line 394
    new-array v2, v3, [I

    fill-array-data v2, :array_ce

    aput-object v2, v0, v1

    const/16 v1, 0xcf

    .line 395
    new-array v2, v3, [I

    fill-array-data v2, :array_cf

    aput-object v2, v0, v1

    const/16 v1, 0xd0

    .line 396
    new-array v2, v3, [I

    fill-array-data v2, :array_d0

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/kkinder/charmap/Charmap;->charmaps:[[I

    .line 400
    const/16 v0, 0xd1

    new-array v0, v0, [Ljava/lang/String;

    .line 401
    const-string v1, "Basic Latin"

    aput-object v1, v0, v4

    .line 402
    const-string v1, "Latin-1 Supplement"

    aput-object v1, v0, v5

    .line 403
    const-string v1, "Latin Extended-A"

    aput-object v1, v0, v3

    .line 404
    const-string v1, "Latin Extended-B"

    aput-object v1, v0, v6

    .line 405
    const-string v1, "IPA Extensions"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    .line 406
    const-string v2, "Spacing Modifier Letters"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    .line 407
    const-string v2, "Combining Diacritical Marks"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    .line 408
    const-string v2, "Greek and Coptic"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    .line 409
    const-string v2, "Cyrillic"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    .line 410
    const-string v2, "Cyrillic Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    .line 411
    const-string v2, "Armenian"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    .line 412
    const-string v2, "Hebrew"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    .line 413
    const-string v2, "Arabic"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    .line 414
    const-string v2, "Syriac"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    .line 415
    const-string v2, "Arabic Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    .line 416
    const-string v2, "Thaana"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    .line 417
    const-string v2, "NKo"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    .line 418
    const-string v2, "Samaritan"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    .line 419
    const-string v2, "Mandaic"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    .line 420
    const-string v2, "Devanagari"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    .line 421
    const-string v2, "Bengali"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    .line 422
    const-string v2, "Gurmukhi"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    .line 423
    const-string v2, "Gujarati"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    .line 424
    const-string v2, "Oriya"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    .line 425
    const-string v2, "Tamil"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    .line 426
    const-string v2, "Telugu"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    .line 427
    const-string v2, "Kannada"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    .line 428
    const-string v2, "Malayalam"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    .line 429
    const-string v2, "Sinhala"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    .line 430
    const-string v2, "Thai"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    .line 431
    const-string v2, "Lao"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    .line 432
    const-string v2, "Tibetan"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    .line 433
    const-string v2, "Myanmar"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    .line 434
    const-string v2, "Georgian"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    .line 435
    const-string v2, "Hangul Jamo"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    .line 436
    const-string v2, "Ethiopic"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    .line 437
    const-string v2, "Ethiopic Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    .line 438
    const-string v2, "Cherokee"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    .line 439
    const-string v2, "Unified Canadian Aboriginal Syllabics"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    .line 440
    const-string v2, "Ogham"

    aput-object v2, v0, v1

    const/16 v1, 0x28

    .line 441
    const-string v2, "Runic"

    aput-object v2, v0, v1

    const/16 v1, 0x29

    .line 442
    const-string v2, "Tagalog"

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    .line 443
    const-string v2, "Hanunoo"

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    .line 444
    const-string v2, "Buhid"

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    .line 445
    const-string v2, "Tagbanwa"

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    .line 446
    const-string v2, "Khmer"

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    .line 447
    const-string v2, "Mongolian"

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    .line 448
    const-string v2, "Unified Canadian Aboriginal Syllabics Extended"

    aput-object v2, v0, v1

    const/16 v1, 0x30

    .line 449
    const-string v2, "Limbu"

    aput-object v2, v0, v1

    const/16 v1, 0x31

    .line 450
    const-string v2, "Tai Le"

    aput-object v2, v0, v1

    const/16 v1, 0x32

    .line 451
    const-string v2, "New Tai Lue"

    aput-object v2, v0, v1

    const/16 v1, 0x33

    .line 452
    const-string v2, "Khmer Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0x34

    .line 453
    const-string v2, "Buginese"

    aput-object v2, v0, v1

    const/16 v1, 0x35

    .line 454
    const-string v2, "Tai Tham"

    aput-object v2, v0, v1

    const/16 v1, 0x36

    .line 455
    const-string v2, "Balinese"

    aput-object v2, v0, v1

    const/16 v1, 0x37

    .line 456
    const-string v2, "Sundanese"

    aput-object v2, v0, v1

    const/16 v1, 0x38

    .line 457
    const-string v2, "Batak"

    aput-object v2, v0, v1

    const/16 v1, 0x39

    .line 458
    const-string v2, "Lepcha"

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    .line 459
    const-string v2, "Ol Chiki"

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    .line 460
    const-string v2, "Vedic Extensions"

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    .line 461
    const-string v2, "Phonetic Extensions"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    .line 462
    const-string v2, "Phonetic Extensions Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    .line 463
    const-string v2, "Combining Diacritical Marks Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    .line 464
    const-string v2, "Latin Extended Additional"

    aput-object v2, v0, v1

    const/16 v1, 0x40

    .line 465
    const-string v2, "Greek Extended"

    aput-object v2, v0, v1

    const/16 v1, 0x41

    .line 466
    const-string v2, "General Punctuation"

    aput-object v2, v0, v1

    const/16 v1, 0x42

    .line 467
    const-string v2, "Superscripts and Subscripts"

    aput-object v2, v0, v1

    const/16 v1, 0x43

    .line 468
    const-string v2, "Currency Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0x44

    .line 469
    const-string v2, "Combining Diacritical Marks for Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0x45

    .line 470
    const-string v2, "Letterlike Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0x46

    .line 471
    const-string v2, "Number Forms"

    aput-object v2, v0, v1

    const/16 v1, 0x47

    .line 472
    const-string v2, "Arrows"

    aput-object v2, v0, v1

    const/16 v1, 0x48

    .line 473
    const-string v2, "Mathematical Operators"

    aput-object v2, v0, v1

    const/16 v1, 0x49

    .line 474
    const-string v2, "Miscellaneous Technical"

    aput-object v2, v0, v1

    const/16 v1, 0x4a

    .line 475
    const-string v2, "Control Pictures"

    aput-object v2, v0, v1

    const/16 v1, 0x4b

    .line 476
    const-string v2, "Optical Character Recognition"

    aput-object v2, v0, v1

    const/16 v1, 0x4c

    .line 477
    const-string v2, "Enclosed Alphanumerics"

    aput-object v2, v0, v1

    const/16 v1, 0x4d

    .line 478
    const-string v2, "Box Drawing"

    aput-object v2, v0, v1

    const/16 v1, 0x4e

    .line 479
    const-string v2, "Block Elements"

    aput-object v2, v0, v1

    const/16 v1, 0x4f

    .line 480
    const-string v2, "Geometric Shapes"

    aput-object v2, v0, v1

    const/16 v1, 0x50

    .line 481
    const-string v2, "Miscellaneous Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0x51

    .line 482
    const-string v2, "Dingbats"

    aput-object v2, v0, v1

    const/16 v1, 0x52

    .line 483
    const-string v2, "Miscellaneous Mathematical Symbols-A"

    aput-object v2, v0, v1

    const/16 v1, 0x53

    .line 484
    const-string v2, "Supplemental Arrows-A"

    aput-object v2, v0, v1

    const/16 v1, 0x54

    .line 485
    const-string v2, "Braille Patterns"

    aput-object v2, v0, v1

    const/16 v1, 0x55

    .line 486
    const-string v2, "Supplemental Arrows-B"

    aput-object v2, v0, v1

    const/16 v1, 0x56

    .line 487
    const-string v2, "Miscellaneous Mathematical Symbols-B"

    aput-object v2, v0, v1

    const/16 v1, 0x57

    .line 488
    const-string v2, "Supplemental Mathematical Operators"

    aput-object v2, v0, v1

    const/16 v1, 0x58

    .line 489
    const-string v2, "Miscellaneous Symbols and Arrows"

    aput-object v2, v0, v1

    const/16 v1, 0x59

    .line 490
    const-string v2, "Glagolitic"

    aput-object v2, v0, v1

    const/16 v1, 0x5a

    .line 491
    const-string v2, "Latin Extended-C"

    aput-object v2, v0, v1

    const/16 v1, 0x5b

    .line 492
    const-string v2, "Coptic"

    aput-object v2, v0, v1

    const/16 v1, 0x5c

    .line 493
    const-string v2, "Georgian Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0x5d

    .line 494
    const-string v2, "Tifinagh"

    aput-object v2, v0, v1

    const/16 v1, 0x5e

    .line 495
    const-string v2, "Ethiopic Extended"

    aput-object v2, v0, v1

    const/16 v1, 0x5f

    .line 496
    const-string v2, "Cyrillic Extended-A"

    aput-object v2, v0, v1

    const/16 v1, 0x60

    .line 497
    const-string v2, "Supplemental Punctuation"

    aput-object v2, v0, v1

    const/16 v1, 0x61

    .line 498
    const-string v2, "CJK Radicals Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0x62

    .line 499
    const-string v2, "Kangxi Radicals"

    aput-object v2, v0, v1

    const/16 v1, 0x63

    .line 500
    const-string v2, "Ideographic Description Characters"

    aput-object v2, v0, v1

    const/16 v1, 0x64

    .line 501
    const-string v2, "CJK Symbols and Punctuation"

    aput-object v2, v0, v1

    const/16 v1, 0x65

    .line 502
    const-string v2, "Hiragana"

    aput-object v2, v0, v1

    const/16 v1, 0x66

    .line 503
    const-string v2, "Katakana"

    aput-object v2, v0, v1

    const/16 v1, 0x67

    .line 504
    const-string v2, "Bopomofo"

    aput-object v2, v0, v1

    const/16 v1, 0x68

    .line 505
    const-string v2, "Hangul Compatibility Jamo"

    aput-object v2, v0, v1

    const/16 v1, 0x69

    .line 506
    const-string v2, "Kanbun"

    aput-object v2, v0, v1

    const/16 v1, 0x6a

    .line 507
    const-string v2, "Bopomofo Extended"

    aput-object v2, v0, v1

    const/16 v1, 0x6b

    .line 508
    const-string v2, "CJK Strokes"

    aput-object v2, v0, v1

    const/16 v1, 0x6c

    .line 509
    const-string v2, "Katakana Phonetic Extensions"

    aput-object v2, v0, v1

    const/16 v1, 0x6d

    .line 510
    const-string v2, "Enclosed CJK Letters and Months"

    aput-object v2, v0, v1

    const/16 v1, 0x6e

    .line 511
    const-string v2, "CJK Compatibility"

    aput-object v2, v0, v1

    const/16 v1, 0x6f

    .line 512
    const-string v2, "CJK Unified Ideographs Extension A"

    aput-object v2, v0, v1

    const/16 v1, 0x70

    .line 513
    const-string v2, "Yijing Hexagram Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0x71

    .line 514
    const-string v2, "CJK Unified Ideographs"

    aput-object v2, v0, v1

    const/16 v1, 0x72

    .line 515
    const-string v2, "Yi Syllables"

    aput-object v2, v0, v1

    const/16 v1, 0x73

    .line 516
    const-string v2, "Yi Radicals"

    aput-object v2, v0, v1

    const/16 v1, 0x74

    .line 517
    const-string v2, "Lisu"

    aput-object v2, v0, v1

    const/16 v1, 0x75

    .line 518
    const-string v2, "Vai"

    aput-object v2, v0, v1

    const/16 v1, 0x76

    .line 519
    const-string v2, "Cyrillic Extended-B"

    aput-object v2, v0, v1

    const/16 v1, 0x77

    .line 520
    const-string v2, "Bamum"

    aput-object v2, v0, v1

    const/16 v1, 0x78

    .line 521
    const-string v2, "Modifier Tone Letters"

    aput-object v2, v0, v1

    const/16 v1, 0x79

    .line 522
    const-string v2, "Latin Extended-D"

    aput-object v2, v0, v1

    const/16 v1, 0x7a

    .line 523
    const-string v2, "Syloti Nagri"

    aput-object v2, v0, v1

    const/16 v1, 0x7b

    .line 524
    const-string v2, "Common Indic Number Forms"

    aput-object v2, v0, v1

    const/16 v1, 0x7c

    .line 525
    const-string v2, "Phags-pa"

    aput-object v2, v0, v1

    const/16 v1, 0x7d

    .line 526
    const-string v2, "Saurashtra"

    aput-object v2, v0, v1

    const/16 v1, 0x7e

    .line 527
    const-string v2, "Devanagari Extended"

    aput-object v2, v0, v1

    const/16 v1, 0x7f

    .line 528
    const-string v2, "Kayah Li"

    aput-object v2, v0, v1

    const/16 v1, 0x80

    .line 529
    const-string v2, "Rejang"

    aput-object v2, v0, v1

    const/16 v1, 0x81

    .line 530
    const-string v2, "Hangul Jamo Extended-A"

    aput-object v2, v0, v1

    const/16 v1, 0x82

    .line 531
    const-string v2, "Javanese"

    aput-object v2, v0, v1

    const/16 v1, 0x83

    .line 532
    const-string v2, "Cham"

    aput-object v2, v0, v1

    const/16 v1, 0x84

    .line 533
    const-string v2, "Myanmar Extended-A"

    aput-object v2, v0, v1

    const/16 v1, 0x85

    .line 534
    const-string v2, "Tai Viet"

    aput-object v2, v0, v1

    const/16 v1, 0x86

    .line 535
    const-string v2, "Ethiopic Extended-A"

    aput-object v2, v0, v1

    const/16 v1, 0x87

    .line 536
    const-string v2, "Meetei Mayek"

    aput-object v2, v0, v1

    const/16 v1, 0x88

    .line 537
    const-string v2, "Hangul Syllables"

    aput-object v2, v0, v1

    const/16 v1, 0x89

    .line 538
    const-string v2, "Hangul Jamo Extended-B"

    aput-object v2, v0, v1

    const/16 v1, 0x8a

    .line 539
    const-string v2, "High Surrogates"

    aput-object v2, v0, v1

    const/16 v1, 0x8b

    .line 540
    const-string v2, "High Private Use Surrogates"

    aput-object v2, v0, v1

    const/16 v1, 0x8c

    .line 541
    const-string v2, "Low Surrogates"

    aput-object v2, v0, v1

    const/16 v1, 0x8d

    .line 542
    const-string v2, "Private Use Area"

    aput-object v2, v0, v1

    const/16 v1, 0x8e

    .line 543
    const-string v2, "CJK Compatibility Ideographs"

    aput-object v2, v0, v1

    const/16 v1, 0x8f

    .line 544
    const-string v2, "Alphabetic Presentation Forms"

    aput-object v2, v0, v1

    const/16 v1, 0x90

    .line 545
    const-string v2, "Arabic Presentation Forms-A"

    aput-object v2, v0, v1

    const/16 v1, 0x91

    .line 546
    const-string v2, "Variation Selectors"

    aput-object v2, v0, v1

    const/16 v1, 0x92

    .line 547
    const-string v2, "Vertical Forms"

    aput-object v2, v0, v1

    const/16 v1, 0x93

    .line 548
    const-string v2, "Combining Half Marks"

    aput-object v2, v0, v1

    const/16 v1, 0x94

    .line 549
    const-string v2, "CJK Compatibility Forms"

    aput-object v2, v0, v1

    const/16 v1, 0x95

    .line 550
    const-string v2, "Small Form Variants"

    aput-object v2, v0, v1

    const/16 v1, 0x96

    .line 551
    const-string v2, "Arabic Presentation Forms-B"

    aput-object v2, v0, v1

    const/16 v1, 0x97

    .line 552
    const-string v2, "Halfwidth and Fullwidth Forms"

    aput-object v2, v0, v1

    const/16 v1, 0x98

    .line 553
    const-string v2, "Specials"

    aput-object v2, v0, v1

    const/16 v1, 0x99

    .line 554
    const-string v2, "Linear B Syllabary"

    aput-object v2, v0, v1

    const/16 v1, 0x9a

    .line 555
    const-string v2, "Linear B Ideograms"

    aput-object v2, v0, v1

    const/16 v1, 0x9b

    .line 556
    const-string v2, "Aegean Numbers"

    aput-object v2, v0, v1

    const/16 v1, 0x9c

    .line 557
    const-string v2, "Ancient Greek Numbers"

    aput-object v2, v0, v1

    const/16 v1, 0x9d

    .line 558
    const-string v2, "Ancient Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0x9e

    .line 559
    const-string v2, "Phaistos Disc"

    aput-object v2, v0, v1

    const/16 v1, 0x9f

    .line 560
    const-string v2, "Lycian"

    aput-object v2, v0, v1

    const/16 v1, 0xa0

    .line 561
    const-string v2, "Carian"

    aput-object v2, v0, v1

    const/16 v1, 0xa1

    .line 562
    const-string v2, "Old Italic"

    aput-object v2, v0, v1

    const/16 v1, 0xa2

    .line 563
    const-string v2, "Gothic"

    aput-object v2, v0, v1

    const/16 v1, 0xa3

    .line 564
    const-string v2, "Ugaritic"

    aput-object v2, v0, v1

    const/16 v1, 0xa4

    .line 565
    const-string v2, "Old Persian"

    aput-object v2, v0, v1

    const/16 v1, 0xa5

    .line 566
    const-string v2, "Deseret"

    aput-object v2, v0, v1

    const/16 v1, 0xa6

    .line 567
    const-string v2, "Shavian"

    aput-object v2, v0, v1

    const/16 v1, 0xa7

    .line 568
    const-string v2, "Osmanya"

    aput-object v2, v0, v1

    const/16 v1, 0xa8

    .line 569
    const-string v2, "Cypriot Syllabary"

    aput-object v2, v0, v1

    const/16 v1, 0xa9

    .line 570
    const-string v2, "Imperial Aramaic"

    aput-object v2, v0, v1

    const/16 v1, 0xaa

    .line 571
    const-string v2, "Phoenician"

    aput-object v2, v0, v1

    const/16 v1, 0xab

    .line 572
    const-string v2, "Lydian"

    aput-object v2, v0, v1

    const/16 v1, 0xac

    .line 573
    const-string v2, "Kharoshthi"

    aput-object v2, v0, v1

    const/16 v1, 0xad

    .line 574
    const-string v2, "Old South Arabian"

    aput-object v2, v0, v1

    const/16 v1, 0xae

    .line 575
    const-string v2, "Avestan"

    aput-object v2, v0, v1

    const/16 v1, 0xaf

    .line 576
    const-string v2, "Inscriptional Parthian"

    aput-object v2, v0, v1

    const/16 v1, 0xb0

    .line 577
    const-string v2, "Inscriptional Pahlavi"

    aput-object v2, v0, v1

    const/16 v1, 0xb1

    .line 578
    const-string v2, "Old Turkic"

    aput-object v2, v0, v1

    const/16 v1, 0xb2

    .line 579
    const-string v2, "Rumi Numeral Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0xb3

    .line 580
    const-string v2, "Brahmi"

    aput-object v2, v0, v1

    const/16 v1, 0xb4

    .line 581
    const-string v2, "Kaithi"

    aput-object v2, v0, v1

    const/16 v1, 0xb5

    .line 582
    const-string v2, "Cuneiform"

    aput-object v2, v0, v1

    const/16 v1, 0xb6

    .line 583
    const-string v2, "Cuneiform Numbers and Punctuation"

    aput-object v2, v0, v1

    const/16 v1, 0xb7

    .line 584
    const-string v2, "Egyptian Hieroglyphs"

    aput-object v2, v0, v1

    const/16 v1, 0xb8

    .line 585
    const-string v2, "Bamum Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0xb9

    .line 586
    const-string v2, "Kana Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0xba

    .line 587
    const-string v2, "Byzantine Musical Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0xbb

    .line 588
    const-string v2, "Musical Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0xbc

    .line 589
    const-string v2, "Ancient Greek Musical Notation"

    aput-object v2, v0, v1

    const/16 v1, 0xbd

    .line 590
    const-string v2, "Tai Xuan Jing Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0xbe

    .line 591
    const-string v2, "Counting Rod Numerals"

    aput-object v2, v0, v1

    const/16 v1, 0xbf

    .line 592
    const-string v2, "Mathematical Alphanumeric Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0xc0

    .line 593
    const-string v2, "Mahjong Tiles"

    aput-object v2, v0, v1

    const/16 v1, 0xc1

    .line 594
    const-string v2, "Domino Tiles"

    aput-object v2, v0, v1

    const/16 v1, 0xc2

    .line 595
    const-string v2, "Playing Cards"

    aput-object v2, v0, v1

    const/16 v1, 0xc3

    .line 596
    const-string v2, "Enclosed Alphanumeric Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0xc4

    .line 597
    const-string v2, "Enclosed Ideographic Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0xc5

    .line 598
    const-string v2, "Miscellaneous Symbols And Pictographs"

    aput-object v2, v0, v1

    const/16 v1, 0xc6

    .line 599
    const-string v2, "Emoticons"

    aput-object v2, v0, v1

    const/16 v1, 0xc7

    .line 600
    const-string v2, "Transport And Map Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0xc8

    .line 601
    const-string v2, "Alchemical Symbols"

    aput-object v2, v0, v1

    const/16 v1, 0xc9

    .line 602
    const-string v2, "CJK Unified Ideographs Extension B"

    aput-object v2, v0, v1

    const/16 v1, 0xca

    .line 603
    const-string v2, "CJK Unified Ideographs Extension C"

    aput-object v2, v0, v1

    const/16 v1, 0xcb

    .line 604
    const-string v2, "CJK Unified Ideographs Extension D"

    aput-object v2, v0, v1

    const/16 v1, 0xcc

    .line 605
    const-string v2, "CJK Compatibility Ideographs Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0xcd

    .line 606
    const-string v2, "Tags"

    aput-object v2, v0, v1

    const/16 v1, 0xce

    .line 607
    const-string v2, "Variation Selectors Supplement"

    aput-object v2, v0, v1

    const/16 v1, 0xcf

    .line 608
    const-string v2, "Supplementary Private Use Area-A"

    aput-object v2, v0, v1

    const/16 v1, 0xd0

    .line 609
    const-string v2, "Supplementary Private Use Area-B"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/kkinder/charmap/Charmap;->charmapNames:[Ljava/lang/String;

    .line 32
    return-void

    .line 188
    :array_0
    .array-data 4
        0x20
        0x7f
    .end array-data

    .line 189
    :array_1
    .array-data 4
        0xa0
        0xff
    .end array-data

    .line 190
    :array_2
    .array-data 4
        0x100
        0x17f
    .end array-data

    .line 191
    :array_3
    .array-data 4
        0x180
        0x24f
    .end array-data

    .line 192
    :array_4
    .array-data 4
        0x250
        0x2af
    .end array-data

    .line 193
    :array_5
    .array-data 4
        0x2b0
        0x2ff
    .end array-data

    .line 194
    :array_6
    .array-data 4
        0x300
        0x36f
    .end array-data

    .line 195
    :array_7
    .array-data 4
        0x370
        0x3ff
    .end array-data

    .line 196
    :array_8
    .array-data 4
        0x400
        0x4ff
    .end array-data

    .line 197
    :array_9
    .array-data 4
        0x500
        0x52f
    .end array-data

    .line 198
    :array_a
    .array-data 4
        0x530
        0x58f
    .end array-data

    .line 199
    :array_b
    .array-data 4
        0x590
        0x5ff
    .end array-data

    .line 200
    :array_c
    .array-data 4
        0x600
        0x6ff
    .end array-data

    .line 201
    :array_d
    .array-data 4
        0x700
        0x74f
    .end array-data

    .line 202
    :array_e
    .array-data 4
        0x750
        0x77f
    .end array-data

    .line 203
    :array_f
    .array-data 4
        0x780
        0x7bf
    .end array-data

    .line 204
    :array_10
    .array-data 4
        0x7c0
        0x7ff
    .end array-data

    .line 205
    :array_11
    .array-data 4
        0x800
        0x83f
    .end array-data

    .line 206
    :array_12
    .array-data 4
        0x840
        0x85f
    .end array-data

    .line 207
    :array_13
    .array-data 4
        0x900
        0x97f
    .end array-data

    .line 208
    :array_14
    .array-data 4
        0x980
        0x9ff
    .end array-data

    .line 209
    :array_15
    .array-data 4
        0xa00
        0xa7f
    .end array-data

    .line 210
    :array_16
    .array-data 4
        0xa80
        0xaff
    .end array-data

    .line 211
    :array_17
    .array-data 4
        0xb00
        0xb7f
    .end array-data

    .line 212
    :array_18
    .array-data 4
        0xb80
        0xbff
    .end array-data

    .line 213
    :array_19
    .array-data 4
        0xc00
        0xc7f
    .end array-data

    .line 214
    :array_1a
    .array-data 4
        0xc80
        0xcff
    .end array-data

    .line 215
    :array_1b
    .array-data 4
        0xd00
        0xd7f
    .end array-data

    .line 216
    :array_1c
    .array-data 4
        0xd80
        0xdff
    .end array-data

    .line 217
    :array_1d
    .array-data 4
        0xe00
        0xe7f
    .end array-data

    .line 218
    :array_1e
    .array-data 4
        0xe80
        0xeff
    .end array-data

    .line 219
    :array_1f
    .array-data 4
        0xf00
        0xfff
    .end array-data

    .line 220
    :array_20
    .array-data 4
        0x1000
        0x109f
    .end array-data

    .line 221
    :array_21
    .array-data 4
        0x10a0
        0x10ff
    .end array-data

    .line 222
    :array_22
    .array-data 4
        0x1100
        0x11ff
    .end array-data

    .line 223
    :array_23
    .array-data 4
        0x1200
        0x137f
    .end array-data

    .line 224
    :array_24
    .array-data 4
        0x1380
        0x139f
    .end array-data

    .line 225
    :array_25
    .array-data 4
        0x13a0
        0x13ff
    .end array-data

    .line 226
    :array_26
    .array-data 4
        0x1400
        0x167f
    .end array-data

    .line 227
    :array_27
    .array-data 4
        0x1680
        0x169f
    .end array-data

    .line 228
    :array_28
    .array-data 4
        0x16a0
        0x16ff
    .end array-data

    .line 229
    :array_29
    .array-data 4
        0x1700
        0x171f
    .end array-data

    .line 230
    :array_2a
    .array-data 4
        0x1720
        0x173f
    .end array-data

    .line 231
    :array_2b
    .array-data 4
        0x1740
        0x175f
    .end array-data

    .line 232
    :array_2c
    .array-data 4
        0x1760
        0x177f
    .end array-data

    .line 233
    :array_2d
    .array-data 4
        0x1780
        0x17ff
    .end array-data

    .line 234
    :array_2e
    .array-data 4
        0x1800
        0x18af
    .end array-data

    .line 235
    :array_2f
    .array-data 4
        0x18b0
        0x18ff
    .end array-data

    .line 236
    :array_30
    .array-data 4
        0x1900
        0x194f
    .end array-data

    .line 237
    :array_31
    .array-data 4
        0x1950
        0x197f
    .end array-data

    .line 238
    :array_32
    .array-data 4
        0x1980
        0x19df
    .end array-data

    .line 239
    :array_33
    .array-data 4
        0x19e0
        0x19ff
    .end array-data

    .line 240
    :array_34
    .array-data 4
        0x1a00
        0x1a1f
    .end array-data

    .line 241
    :array_35
    .array-data 4
        0x1a20
        0x1aaf
    .end array-data

    .line 242
    :array_36
    .array-data 4
        0x1b00
        0x1b7f
    .end array-data

    .line 243
    :array_37
    .array-data 4
        0x1b80
        0x1bbf
    .end array-data

    .line 244
    :array_38
    .array-data 4
        0x1bc0
        0x1bff
    .end array-data

    .line 245
    :array_39
    .array-data 4
        0x1c00
        0x1c4f
    .end array-data

    .line 246
    :array_3a
    .array-data 4
        0x1c50
        0x1c7f
    .end array-data

    .line 247
    :array_3b
    .array-data 4
        0x1cd0
        0x1cff
    .end array-data

    .line 248
    :array_3c
    .array-data 4
        0x1d00
        0x1d7f
    .end array-data

    .line 249
    :array_3d
    .array-data 4
        0x1d80
        0x1dbf
    .end array-data

    .line 250
    :array_3e
    .array-data 4
        0x1dc0
        0x1dff
    .end array-data

    .line 251
    :array_3f
    .array-data 4
        0x1e00
        0x1eff
    .end array-data

    .line 252
    :array_40
    .array-data 4
        0x1f00
        0x1fff
    .end array-data

    .line 253
    :array_41
    .array-data 4
        0x2000
        0x206f
    .end array-data

    .line 254
    :array_42
    .array-data 4
        0x2070
        0x209f
    .end array-data

    .line 255
    :array_43
    .array-data 4
        0x20a0
        0x20cf
    .end array-data

    .line 256
    :array_44
    .array-data 4
        0x20d0
        0x20ff
    .end array-data

    .line 257
    :array_45
    .array-data 4
        0x2100
        0x214f
    .end array-data

    .line 258
    :array_46
    .array-data 4
        0x2150
        0x218f
    .end array-data

    .line 259
    :array_47
    .array-data 4
        0x2190
        0x21ff
    .end array-data

    .line 260
    :array_48
    .array-data 4
        0x2200
        0x22ff
    .end array-data

    .line 261
    :array_49
    .array-data 4
        0x2300
        0x23ff
    .end array-data

    .line 262
    :array_4a
    .array-data 4
        0x2400
        0x243f
    .end array-data

    .line 263
    :array_4b
    .array-data 4
        0x2440
        0x245f
    .end array-data

    .line 264
    :array_4c
    .array-data 4
        0x2460
        0x24ff
    .end array-data

    .line 265
    :array_4d
    .array-data 4
        0x2500
        0x257f
    .end array-data

    .line 266
    :array_4e
    .array-data 4
        0x2580
        0x259f
    .end array-data

    .line 267
    :array_4f
    .array-data 4
        0x25a0
        0x25ff
    .end array-data

    .line 268
    :array_50
    .array-data 4
        0x2600
        0x26ff
    .end array-data

    .line 269
    :array_51
    .array-data 4
        0x2700
        0x27bf
    .end array-data

    .line 270
    :array_52
    .array-data 4
        0x27c0
        0x27ef
    .end array-data

    .line 271
    :array_53
    .array-data 4
        0x27f0
        0x27ff
    .end array-data

    .line 272
    :array_54
    .array-data 4
        0x2800
        0x28ff
    .end array-data

    .line 273
    :array_55
    .array-data 4
        0x2900
        0x297f
    .end array-data

    .line 274
    :array_56
    .array-data 4
        0x2980
        0x29ff
    .end array-data

    .line 275
    :array_57
    .array-data 4
        0x2a00
        0x2aff
    .end array-data

    .line 276
    :array_58
    .array-data 4
        0x2b00
        0x2bff
    .end array-data

    .line 277
    :array_59
    .array-data 4
        0x2c00
        0x2c5f
    .end array-data

    .line 278
    :array_5a
    .array-data 4
        0x2c60
        0x2c7f
    .end array-data

    .line 279
    :array_5b
    .array-data 4
        0x2c80
        0x2cff
    .end array-data

    .line 280
    :array_5c
    .array-data 4
        0x2d00
        0x2d2f
    .end array-data

    .line 281
    :array_5d
    .array-data 4
        0x2d30
        0x2d7f
    .end array-data

    .line 282
    :array_5e
    .array-data 4
        0x2d80
        0x2ddf
    .end array-data

    .line 283
    :array_5f
    .array-data 4
        0x2de0
        0x2dff
    .end array-data

    .line 284
    :array_60
    .array-data 4
        0x2e00
        0x2e7f
    .end array-data

    .line 285
    :array_61
    .array-data 4
        0x2e80
        0x2eff
    .end array-data

    .line 286
    :array_62
    .array-data 4
        0x2f00
        0x2fdf
    .end array-data

    .line 287
    :array_63
    .array-data 4
        0x2ff0
        0x2fff
    .end array-data

    .line 288
    :array_64
    .array-data 4
        0x3000
        0x303f
    .end array-data

    .line 289
    :array_65
    .array-data 4
        0x3040
        0x309f
    .end array-data

    .line 290
    :array_66
    .array-data 4
        0x30a0
        0x30ff
    .end array-data

    .line 291
    :array_67
    .array-data 4
        0x3100
        0x312f
    .end array-data

    .line 292
    :array_68
    .array-data 4
        0x3130
        0x318f
    .end array-data

    .line 293
    :array_69
    .array-data 4
        0x3190
        0x319f
    .end array-data

    .line 294
    :array_6a
    .array-data 4
        0x31a0
        0x31bf
    .end array-data

    .line 295
    :array_6b
    .array-data 4
        0x31c0
        0x31ef
    .end array-data

    .line 296
    :array_6c
    .array-data 4
        0x31f0
        0x31ff
    .end array-data

    .line 297
    :array_6d
    .array-data 4
        0x3200
        0x32ff
    .end array-data

    .line 298
    :array_6e
    .array-data 4
        0x3300
        0x33ff
    .end array-data

    .line 299
    :array_6f
    .array-data 4
        0x3400
        0x4dbf
    .end array-data

    .line 300
    :array_70
    .array-data 4
        0x4dc0
        0x4dff
    .end array-data

    .line 301
    :array_71
    .array-data 4
        0x4e00
        0x9fff
    .end array-data

    .line 302
    :array_72
    .array-data 4
        0xa000
        0xa48f
    .end array-data

    .line 303
    :array_73
    .array-data 4
        0xa490
        0xa4cf
    .end array-data

    .line 304
    :array_74
    .array-data 4
        0xa4d0
        0xa4ff
    .end array-data

    .line 305
    :array_75
    .array-data 4
        0xa500
        0xa63f
    .end array-data

    .line 306
    :array_76
    .array-data 4
        0xa640
        0xa69f
    .end array-data

    .line 307
    :array_77
    .array-data 4
        0xa6a0
        0xa6ff
    .end array-data

    .line 308
    :array_78
    .array-data 4
        0xa700
        0xa71f
    .end array-data

    .line 309
    :array_79
    .array-data 4
        0xa720
        0xa7ff
    .end array-data

    .line 310
    :array_7a
    .array-data 4
        0xa800
        0xa82f
    .end array-data

    .line 311
    :array_7b
    .array-data 4
        0xa830
        0xa83f
    .end array-data

    .line 312
    :array_7c
    .array-data 4
        0xa840
        0xa87f
    .end array-data

    .line 313
    :array_7d
    .array-data 4
        0xa880
        0xa8df
    .end array-data

    .line 314
    :array_7e
    .array-data 4
        0xa8e0
        0xa8ff
    .end array-data

    .line 315
    :array_7f
    .array-data 4
        0xa900
        0xa92f
    .end array-data

    .line 316
    :array_80
    .array-data 4
        0xa930
        0xa95f
    .end array-data

    .line 317
    :array_81
    .array-data 4
        0xa960
        0xa97f
    .end array-data

    .line 318
    :array_82
    .array-data 4
        0xa980
        0xa9df
    .end array-data

    .line 319
    :array_83
    .array-data 4
        0xaa00
        0xaa5f
    .end array-data

    .line 320
    :array_84
    .array-data 4
        0xaa60
        0xaa7f
    .end array-data

    .line 321
    :array_85
    .array-data 4
        0xaa80
        0xaadf
    .end array-data

    .line 322
    :array_86
    .array-data 4
        0xab00
        0xab2f
    .end array-data

    .line 323
    :array_87
    .array-data 4
        0xabc0
        0xabff
    .end array-data

    .line 324
    :array_88
    .array-data 4
        0xac00
        0xd7af
    .end array-data

    .line 325
    :array_89
    .array-data 4
        0xd7b0
        0xd7ff
    .end array-data

    .line 326
    :array_8a
    .array-data 4
        0xd800
        0xdb7f
    .end array-data

    .line 327
    :array_8b
    .array-data 4
        0xdb80
        0xdbff
    .end array-data

    .line 328
    :array_8c
    .array-data 4
        0xdc00
        0xdfff
    .end array-data

    .line 329
    :array_8d
    .array-data 4
        0xe000
        0xf8ff
    .end array-data

    .line 330
    :array_8e
    .array-data 4
        0xf900
        0xfaff
    .end array-data

    .line 331
    :array_8f
    .array-data 4
        0xfb00
        0xfb4f
    .end array-data

    .line 332
    :array_90
    .array-data 4
        0xfb50
        0xfdff
    .end array-data

    .line 333
    :array_91
    .array-data 4
        0xfe00
        0xfe0f
    .end array-data

    .line 334
    :array_92
    .array-data 4
        0xfe10
        0xfe1f
    .end array-data

    .line 335
    :array_93
    .array-data 4
        0xfe20
        0xfe2f
    .end array-data

    .line 336
    :array_94
    .array-data 4
        0xfe30
        0xfe4f
    .end array-data

    .line 337
    :array_95
    .array-data 4
        0xfe50
        0xfe6f
    .end array-data

    .line 338
    :array_96
    .array-data 4
        0xfe70
        0xfeff
    .end array-data

    .line 339
    :array_97
    .array-data 4
        0xff00
        0xffef
    .end array-data

    .line 340
    :array_98
    .array-data 4
        0xfff0
        0xffff
    .end array-data

    .line 341
    :array_99
    .array-data 4
        0x10000
        0x1007f
    .end array-data

    .line 342
    :array_9a
    .array-data 4
        0x10080
        0x100ff
    .end array-data

    .line 343
    :array_9b
    .array-data 4
        0x10100
        0x1013f
    .end array-data

    .line 344
    :array_9c
    .array-data 4
        0x10140
        0x1018f
    .end array-data

    .line 345
    :array_9d
    .array-data 4
        0x10190
        0x101cf
    .end array-data

    .line 346
    :array_9e
    .array-data 4
        0x101d0
        0x101ff
    .end array-data

    .line 347
    :array_9f
    .array-data 4
        0x10280
        0x1029f
    .end array-data

    .line 348
    :array_a0
    .array-data 4
        0x102a0
        0x102df
    .end array-data

    .line 349
    :array_a1
    .array-data 4
        0x10300
        0x1032f
    .end array-data

    .line 350
    :array_a2
    .array-data 4
        0x10330
        0x1034f
    .end array-data

    .line 351
    :array_a3
    .array-data 4
        0x10380
        0x1039f
    .end array-data

    .line 352
    :array_a4
    .array-data 4
        0x103a0
        0x103df
    .end array-data

    .line 353
    :array_a5
    .array-data 4
        0x10400
        0x1044f
    .end array-data

    .line 354
    :array_a6
    .array-data 4
        0x10450
        0x1047f
    .end array-data

    .line 355
    :array_a7
    .array-data 4
        0x10480
        0x104af
    .end array-data

    .line 356
    :array_a8
    .array-data 4
        0x10800
        0x1083f
    .end array-data

    .line 357
    :array_a9
    .array-data 4
        0x10840
        0x1085f
    .end array-data

    .line 358
    :array_aa
    .array-data 4
        0x10900
        0x1091f
    .end array-data

    .line 359
    :array_ab
    .array-data 4
        0x10920
        0x1093f
    .end array-data

    .line 360
    :array_ac
    .array-data 4
        0x10a00
        0x10a5f
    .end array-data

    .line 361
    :array_ad
    .array-data 4
        0x10a60
        0x10a7f
    .end array-data

    .line 362
    :array_ae
    .array-data 4
        0x10b00
        0x10b3f
    .end array-data

    .line 363
    :array_af
    .array-data 4
        0x10b40
        0x10b5f
    .end array-data

    .line 364
    :array_b0
    .array-data 4
        0x10b60
        0x10b7f
    .end array-data

    .line 365
    :array_b1
    .array-data 4
        0x10c00
        0x10c4f
    .end array-data

    .line 366
    :array_b2
    .array-data 4
        0x10e60
        0x10e7f
    .end array-data

    .line 367
    :array_b3
    .array-data 4
        0x11000
        0x1107f
    .end array-data

    .line 368
    :array_b4
    .array-data 4
        0x11080
        0x110cf
    .end array-data

    .line 369
    :array_b5
    .array-data 4
        0x12000
        0x123ff
    .end array-data

    .line 370
    :array_b6
    .array-data 4
        0x12400
        0x1247f
    .end array-data

    .line 371
    :array_b7
    .array-data 4
        0x13000
        0x1342f
    .end array-data

    .line 372
    :array_b8
    .array-data 4
        0x16800
        0x16a3f
    .end array-data

    .line 373
    :array_b9
    .array-data 4
        0x1b000
        0x1b0ff
    .end array-data

    .line 374
    :array_ba
    .array-data 4
        0x1d000
        0x1d0ff
    .end array-data

    .line 375
    :array_bb
    .array-data 4
        0x1d100
        0x1d1ff
    .end array-data

    .line 376
    :array_bc
    .array-data 4
        0x1d200
        0x1d24f
    .end array-data

    .line 377
    :array_bd
    .array-data 4
        0x1d300
        0x1d35f
    .end array-data

    .line 378
    :array_be
    .array-data 4
        0x1d360
        0x1d37f
    .end array-data

    .line 379
    :array_bf
    .array-data 4
        0x1d400
        0x1d7ff
    .end array-data

    .line 380
    :array_c0
    .array-data 4
        0x1f000
        0x1f02f
    .end array-data

    .line 381
    :array_c1
    .array-data 4
        0x1f030
        0x1f09f
    .end array-data

    .line 382
    :array_c2
    .array-data 4
        0x1f0a0
        0x1f0ff
    .end array-data

    .line 383
    :array_c3
    .array-data 4
        0x1f100
        0x1f1ff
    .end array-data

    .line 384
    :array_c4
    .array-data 4
        0x1f200
        0x1f2ff
    .end array-data

    .line 385
    :array_c5
    .array-data 4
        0x1f300
        0x1f5ff
    .end array-data

    .line 386
    :array_c6
    .array-data 4
        0x1f600
        0x1f64f
    .end array-data

    .line 387
    :array_c7
    .array-data 4
        0x1f680
        0x1f6ff
    .end array-data

    .line 388
    :array_c8
    .array-data 4
        0x1f700
        0x1f77f
    .end array-data

    .line 389
    :array_c9
    .array-data 4
        0x20000
        0x2a6df
    .end array-data

    .line 390
    :array_ca
    .array-data 4
        0x2a700
        0x2b73f
    .end array-data

    .line 391
    :array_cb
    .array-data 4
        0x2b740
        0x2b81f
    .end array-data

    .line 392
    :array_cc
    .array-data 4
        0x2f800
        0x2fa1f
    .end array-data

    .line 393
    :array_cd
    .array-data 4
        0xe0000
        0xe007f
    .end array-data

    .line 394
    :array_ce
    .array-data 4
        0xe0100
        0xe01ef
    .end array-data

    .line 395
    :array_cf
    .array-data 4
        0xf0000
        0xfffff
    .end array-data

    .line 396
    :array_d0
    .array-data 4
        0x100000
        0x10ffff
    .end array-data
.end method

.method static synthetic access$0(Lcom/kkinder/charmap/Charmap;)Landroid/app/Dialog;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;

    return-object v0
.end method

.method static synthetic access$1(Lcom/kkinder/charmap/Charmap;I)V
    .locals 0

    .prologue
    .line 35
    iput p1, p0, Lcom/kkinder/charmap/Charmap;->page:I

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    .line 122
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 123
    const v4, 0x7f030001

    invoke-virtual {p0, v4}, Lcom/kkinder/charmap/Charmap;->setContentView(I)V

    .line 126
    invoke-virtual {p0, v5}, Lcom/kkinder/charmap/Charmap;->getPreferences(I)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 127
    .local v3, "settings":Landroid/content/SharedPreferences;
    const-string v4, "batchMode"

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, p0, Lcom/kkinder/charmap/Charmap;->batchMode:Ljava/lang/Boolean;

    .line 128
    const-string v4, "page"

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Lcom/kkinder/charmap/Charmap;->page:I

    .line 130
    iget-object v4, p0, Lcom/kkinder/charmap/Charmap;->batchMode:Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {p0, v4}, Lcom/kkinder/charmap/Charmap;->updateBatchMode(Z)V

    .line 133
    const v4, 0x7f060004

    invoke-virtual {p0, v4}, Lcom/kkinder/charmap/Charmap;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Spinner;

    .line 134
    .local v2, "sectionSpinner":Landroid/widget/Spinner;
    const v4, 0x7f060008

    invoke-virtual {p0, v4}, Lcom/kkinder/charmap/Charmap;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 136
    .local v1, "copyButton":Landroid/widget/Button;
    new-instance v4, Lcom/kkinder/charmap/Charmap$2;

    invoke-direct {v4, p0}, Lcom/kkinder/charmap/Charmap$2;-><init>(Lcom/kkinder/charmap/Charmap;)V

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 153
    new-instance v0, Landroid/widget/ArrayAdapter;

    const v4, 0x1090008

    iget-object v5, p0, Lcom/kkinder/charmap/Charmap;->charmapNames:[Ljava/lang/String;

    invoke-direct {v0, p0, v4, v5}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 154
    .local v0, "adapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Ljava/lang/CharSequence;>;"
    const v4, 0x1090009

    invoke-virtual {v0, v4}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 155
    invoke-virtual {v2, v0}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 156
    iget v4, p0, Lcom/kkinder/charmap/Charmap;->page:I

    invoke-virtual {v2, v4}, Landroid/widget/Spinner;->setSelection(I)V

    .line 157
    new-instance v4, Lcom/kkinder/charmap/Charmap$3;

    invoke-direct {v4, p0}, Lcom/kkinder/charmap/Charmap$3;-><init>(Lcom/kkinder/charmap/Charmap;)V

    invoke-virtual {v2, v4}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 184
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 39
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    .line 40
    invoke-virtual {p0}, Lcom/kkinder/charmap/Charmap;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 41
    .local v0, "inflater":Landroid/view/MenuInflater;
    const/high16 v1, 0x7f050000

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 42
    const/4 v1, 0x1

    return v1
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 5
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 74
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    .line 76
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 107
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v2

    :goto_0
    return v2

    .line 78
    :pswitch_0
    new-instance v2, Landroid/app/Dialog;

    invoke-direct {v2, p0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;

    .line 80
    iget-object v2, p0, Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;

    const/high16 v3, 0x7f030000

    invoke-virtual {v2, v3}, Landroid/app/Dialog;->setContentView(I)V

    .line 81
    iget-object v2, p0, Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;

    const v3, 0x7f060002

    invoke-virtual {v2, v3}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 82
    .local v0, "aboutText":Landroid/widget/TextView;
    const v2, 0x7f040007

    invoke-virtual {p0, v2}, Lcom/kkinder/charmap/Charmap;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 85
    iget-object v2, p0, Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;

    const v3, 0x7f040006

    invoke-virtual {v2, v3}, Landroid/app/Dialog;->setTitle(I)V

    .line 86
    iget-object v2, p0, Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;

    invoke-virtual {v2, v4}, Landroid/app/Dialog;->setCancelable(Z)V

    .line 88
    iget-object v2, p0, Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;

    const v3, 0x7f060003

    invoke-virtual {v2, v3}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 90
    .local v1, "closeButton":Landroid/widget/Button;
    new-instance v2, Lcom/kkinder/charmap/Charmap$1;

    invoke-direct {v2, p0}, Lcom/kkinder/charmap/Charmap$1;-><init>(Lcom/kkinder/charmap/Charmap;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 96
    iget-object v2, p0, Lcom/kkinder/charmap/Charmap;->dialog:Landroid/app/Dialog;

    invoke-virtual {v2}, Landroid/app/Dialog;->show()V

    move v2, v4

    .line 97
    goto :goto_0

    .line 99
    .end local v0    # "aboutText":Landroid/widget/TextView;
    .end local v1    # "closeButton":Landroid/widget/Button;
    :pswitch_1
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/kkinder/charmap/Charmap;->batchMode:Ljava/lang/Boolean;

    .line 100
    invoke-virtual {p0, v4}, Lcom/kkinder/charmap/Charmap;->updateBatchMode(Z)V

    move v2, v4

    .line 101
    goto :goto_0

    .line 103
    :pswitch_2
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/kkinder/charmap/Charmap;->batchMode:Ljava/lang/Boolean;

    .line 104
    invoke-virtual {p0, v3}, Lcom/kkinder/charmap/Charmap;->updateBatchMode(Z)V

    move v2, v4

    .line 105
    goto :goto_0

    .line 76
    :pswitch_data_0
    .packed-switch 0x7f060009
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 5
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const v4, 0x7f06000b

    const v3, 0x7f06000a

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 62
    iget-object v0, p0, Lcom/kkinder/charmap/Charmap;->batchMode:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 64
    invoke-interface {p1, v4}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 69
    :goto_0
    invoke-super {p0, p1}, Landroid/app/Activity;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0

    .line 66
    :cond_0
    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 67
    invoke-interface {p1, v4}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 47
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 49
    invoke-virtual {p0}, Lcom/kkinder/charmap/Charmap;->savePreferences()V

    .line 50
    return-void
.end method

.method public savePreferences()V
    .locals 4

    .prologue
    .line 53
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/kkinder/charmap/Charmap;->getPreferences(I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 54
    .local v1, "settings":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 55
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "batchMode"

    iget-object v3, p0, Lcom/kkinder/charmap/Charmap;->batchMode:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 56
    const-string v2, "page"

    iget v3, p0, Lcom/kkinder/charmap/Charmap;->page:I

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 57
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 58
    return-void
.end method

.method public updateBatchMode(Z)V
    .locals 2
    .param p1, "batchMode"    # Z

    .prologue
    .line 112
    const v1, 0x7f060006

    invoke-virtual {p0, v1}, Lcom/kkinder/charmap/Charmap;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 113
    .local v0, "editArea":Landroid/widget/LinearLayout;
    if-eqz p1, :cond_0

    .line 114
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 118
    :goto_0
    return-void

    .line 116
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method
