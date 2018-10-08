using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tests.Cases;
using Tests.Cases.PTGFixedPoint;
using Tests.Util;

namespace Tests
{
    [TestClass]
    public class FedeTests : BaseSlicingTest
    {
        [TestMethod]
        public void SimpleListTest()
        {
            var testedType = typeof(SimpleListTest);
            var sameFile = SameFileStmtBuilder(testedType);
            TestSimpleSlice(testedType, new TestResult
            {
                Criteria = sameFile.WithLine(20),
                Sliced =
                    {
                        sameFile.WithLine(20),
                        sameFile.WithLine(16),
                    },
            }
            );
        }

        [TestMethod]
        public void ExternalListTest()
        {
            var testedType = typeof(ExternalListTest);
            var sameFile = SameFileStmtBuilder(testedType);
            TestSimpleSlice(testedType, new TestResult
            {
                Criteria = sameFile.WithLine(21),
                Sliced =
                    {
                        sameFile.WithLine(21),
                        sameFile.WithLine(17),
                        sameFile.WithLine(20),
                        sameFile.WithLine(15),
                        sameFile.WithLine(19),
                    },
            }
            );
        }

        [TestMethod]
        public void SimpleListCycleTest()
        {
            var testedType = typeof(SimpleListCycleTest);
            var sameFile = SameFileStmtBuilder(testedType);
            TestSimpleSlice(testedType, new TestResult
            {
                Criteria = sameFile.WithLine(23),
                Sliced =
                    {
                        sameFile.WithLine(23),
                        sameFile.WithLine(20),
                        sameFile.WithLine(16),
                    },
            }
            );
        }

        [TestMethod]
        public void ExtermalListCycleTest()
        {
            var testedType = typeof(ExtermalListCycleTest);
            var sameFile = SameFileStmtBuilder(testedType);
            TestSimpleSlice(testedType, new TestResult
            {
                Criteria = sameFile.WithLine(23),
                Sliced =
                    {
                        sameFile.WithLine(23),
                        sameFile.WithLine(20),
                        sameFile.WithLine(18),
                        sameFile.WithLine(16),
                        sameFile.WithLine(15),
                    },
            }
            );
        }

        [TestMethod]
        public void ExternalListInheritanceTest()
        {
            var testedType = typeof(ExternalListInheritanceTest);
            var sameFile = SameFileStmtBuilder(testedType);
            TestSimpleSlice(testedType, new TestResult
            {
                Criteria = sameFile.WithLine(14),
                Sliced =
                    {
                        sameFile.WithLine(14),
                    },
            }
            );
        }
    }
}
